package danbroid.util.demo.permissions

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import danbroid.util.demo.R
import danbroid.util.permissions.withPermission
import kotlinx.android.synthetic.main.fragment_filebrowser.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class FileBrowserFragment : Fragment() {

  lateinit var adapter: FilesAdapter

  /**
   * The directory path for this fragment
   * defaults to "/sdcard/"
   */
  var path: String
    get() = arguments?.getString("path") ?: "/sdcard/"
    set(value) {
      arguments = bundleOf("path" to value)
    }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ) = inflater.inflate(R.layout.fragment_filebrowser, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    log.info("onViewCreated() $path")
    recycler_view.layoutManager = LinearLayoutManager(context)

    adapter = FilesAdapter {
      val file = it.file!!

      if (file.isDirectory)
        (activity as PermissionsActivity).showDir(file)
      else
        Toast.makeText(context, "Clicked on ${file.name}", Toast.LENGTH_SHORT).show()
    }

    recycler_view.adapter = adapter

    loadFiles()
  }

  /**
   * Launces a coroutine to request [Manifest.permission.READ_EXTERNAL_STORAGE]
   * and if granted will load the contents into the [adapter]
   */
  fun loadFiles() {
    log.debug("loadFiles()")
    lifecycleScope.launch {
      withPermission(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        rationale = getString(R.string.rationale_read_storage)
      ) { granted ->
        log.info("permission granted: $granted")
        if (granted)
          withContext(Dispatchers.IO) {
            //doing file IO on Dispatchers.IO
            File(path).listFiles()?.filter {
              //filter for non empty directories
              !it.isDirectory || !it.listFiles().isNullOrEmpty()
            }?.also {
              withContext(Dispatchers.Main) {
                //update the ui on the main thread
                adapter.setFiles(it)
              }
            }
          }
      }
    }
  }
}

class FileViewHolder(itemView: View, clickListener: (FileViewHolder) -> Unit) :
  RecyclerView.ViewHolder(itemView) {

  val title = itemView.findViewById<TextView>(android.R.id.text1)
  val subTitle = itemView.findViewById<TextView>(android.R.id.text2)
  var file: File? = null

  init {
    itemView.setOnClickListener {
      clickListener.invoke(this)
    }
  }

  fun bind(file: File) {
    log.trace("bind(): $file")
    this.file = file
    title.text = file.name
    subTitle.text = file.absolutePath
  }

}

class FilesAdapter(val clickListener: (FileViewHolder) -> Unit) :
  RecyclerView.Adapter<FileViewHolder>() {

  private var files: List<File> = emptyList()

  fun setFiles(files: List<File>) {
    this.files = files
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileViewHolder {
    val itemView = LayoutInflater.from(parent.context)
      .inflate(android.R.layout.simple_list_item_2, parent, false)
    return FileViewHolder(itemView, clickListener)
  }

  override fun getItemCount() = files.size

  override fun onBindViewHolder(holder: FileViewHolder, position: Int) {
    holder.bind(files[position])
  }

}

private val log = org.slf4j.LoggerFactory.getLogger(FileBrowserFragment::class.java)

