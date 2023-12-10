package edu.ics4u.nicolas;

import java.text.BreakIterator;

public final class AssortedMethods {
  /**
   * https://stackoverflow.com/a/55674580/21416476
   * 
   * @param str
   * @param start
   * @param end
   * @return
   */
  public static String multiCodePointSubstring(String str, int start, int end) {
    // System.out.println(str.length());
    // System.out.println(start);
    // System.out.println(end);
    int offsetStart = str.offsetByCodePoints(0, start);
    // System.out.println(offsetStart);
    int offsetEnd = str.offsetByCodePoints(offsetStart, end - start);

    return str.substring(offsetStart, offsetEnd);
  }

  /**
   * https://stackoverflow.com/a/47058712/21416476
   * 
   * @param s
   * @return
   */
  public static int graphemeLength(String s) {
    BreakIterator it = BreakIterator.getCharacterInstance();
    it.setText(s);
    int count = 0;
    while (it.next() != BreakIterator.DONE) {
        count++;
    }
    return count;
  }
}
