package nl.ncim.shortener

import java.net.{MalformedURLException, URLEncoder}

object UrlShortener {

  /**
   * I shorten the given url
   * @param url
   * @return shorten url
   */
  def shortenUrl(url: String) = {
    val line = io.Source.fromURL("http://url.k47.cz/api/get/?url=" + URLEncoder.encode(url, "UTF8")).getLines.next
    if (line startsWith "ERROR") throw new MalformedURLException
    line
  }
}
