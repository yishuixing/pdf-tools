import java.io.File
import java.nio.file.Paths

import scala.util.Try

object ReName {
  def main(args: Array[String]): Unit = {
    val path = "F:\\imgs\\"
    getListOfFiles(path).map(f => {
      println(f.getName)
      println(f.getName.replaceAll("微信图片_", ""))
      mv(Paths.get(path, f.getName).toString, Paths.get(path, f.getName.replaceAll("微信图片_", "")).toString)
    })
  }

  def getListOfFiles(dir: String): List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  def mv(oldName: String, newName: String) =
    Try(new File(oldName).renameTo(new File(newName))).getOrElse(true)
}
