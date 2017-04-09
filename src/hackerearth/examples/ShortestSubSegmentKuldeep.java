package hackerearth.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ShortestSubSegmentKuldeep {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String inputText = in.nextLine();
		int words = in.nextInt();
		// System.out.println(inParagraph);
		int tmpCountMax = words;

		String thisToken = "";
		String matchedAtom = "";

		String[] para = inputText.split(" ");
		String[] loweredPara = new String[para.length];

		for (int paraIndex = 0; paraIndex < para.length; paraIndex++) {
			if (para[paraIndex].endsWith(".")) {
				para[paraIndex] = para[paraIndex].substring(0,
						para[paraIndex].length() - 1);
			}
			loweredPara[paraIndex] = para[paraIndex].toLowerCase();
		}
		String tmpStringInput = "";
		List<String> inputWords = new ArrayList<String>();
		List<String> buffer = new ArrayList<String>();

		for (int i = 0; i < words; i++) {
			tmpStringInput = in.next().trim().toLowerCase();

			if (!inputWords.contains(tmpStringInput)) {
				inputWords.add(tmpStringInput);
			} else {
				tmpCountMax--;
			}
		}
		int firstOccurPos = 0;
		int storedLength = 0;
		int startIndex = 0;
		int currentLength = 0;
		int resultLength = 0;
		int resultStart = 0;
		int resultEnd = 0;

		HashMap<String, Integer> startTable = new HashMap<String, Integer>();
		HashMap<String, Integer> lenTable = new HashMap<String, Integer>();

		for (int cur = 0; cur < loweredPara.length; cur++) {
			thisToken = loweredPara[cur];
			if (inputWords.contains(thisToken)) {
				if (buffer.contains(thisToken)) {
					// The word exists
					if (buffer.get(0).equals(thisToken)) {
						if (buffer.size() > 1) {
							if (startTable.containsKey(buffer.get(1))) {
								firstOccurPos = startTable.get(buffer
										.get(1));
							}
							if (lenTable.containsKey(buffer.get(1))) {
								storedLength = lenTable.get(buffer
										.get(1));
							}
							currentLength -= storedLength;
							lenTable.remove(buffer.get(1));
							lenTable.put(buffer.get(1), 0);
							startIndex = firstOccurPos;
						} else {
							currentLength = 0;
							startIndex = cur;
						}

						lenTable.remove(thisToken);
						lenTable.put(thisToken, currentLength);
						currentLength += thisToken.length();
						startTable.remove(thisToken);
						startTable.put(thisToken, cur);
						buffer.remove(0);
						if (buffer.size() > 1) {
							int tmpStorage = storedLength;
							for (int tmpIndex = 1; tmpIndex < buffer.size(); tmpIndex++) {
								if (lenTable.containsKey(buffer
										.get(tmpIndex))) {
									storedLength = lenTable.get(buffer
											.get(tmpIndex));
								}
								lenTable.remove(buffer.get(tmpIndex));
								lenTable.put(buffer.get(tmpIndex),
										storedLength - tmpStorage);
							}
						}
						buffer.add(thisToken);
					} else {
						startTable.remove(thisToken);
						startTable.put(thisToken, cur);
						lenTable.remove(thisToken);
						lenTable.put(thisToken, currentLength);
						currentLength += thisToken.length();
						buffer.remove(thisToken);
						buffer.add(thisToken);
					}
				} else {
					if (buffer.size() == 0) {
						startIndex = cur;
					} else {

					}
					buffer.add(thisToken);
					startTable.put(thisToken, cur);
					lenTable.put(thisToken, currentLength);
					currentLength += thisToken.length();
				}
			} else if (buffer.size() > 0) {
				currentLength += thisToken.length();
			}

			if (inputWords.size() == buffer.size()) {
				if (inputWords.size() == 1) {
					currentLength += thisToken.length();
					resultLength = currentLength;
					resultStart = startIndex;
					resultEnd = cur;
					break;
				} else if (resultLength > currentLength || resultLength == 0) {
					resultLength = currentLength;
					resultStart = startIndex;
					resultEnd = cur;
				}

				startTable.remove(buffer.get(0));
				if (lenTable.containsKey(buffer.get(1))) {
					storedLength = lenTable.get(buffer.get(1));
				}

				currentLength -= storedLength;

				lenTable.remove(buffer.get(1));
				lenTable.put(buffer.get(1), 0);
				lenTable.remove(buffer.get(0));
				buffer.remove(0);

				if (buffer.size() > 1) {
					int tmpLen = storedLength;
					for (int tmpIndex = 1; tmpIndex < buffer.size(); tmpIndex++) {
						if (lenTable.containsKey(buffer.get(tmpIndex))) {
							storedLength = lenTable.get(buffer
									.get(tmpIndex));
						}
						lenTable.remove(buffer.get(tmpIndex));
						lenTable.put(buffer.get(tmpIndex), storedLength
								- tmpLen);
					}
				}
				if (startTable.containsKey(buffer.get(0))) {
					startIndex = startTable.get(buffer.get(0));
				}
			}
		}

		if (resultLength == 0) {
			System.out.println("NO SUBSEGMENT FOUND");
		} else {
			for (int index = resultStart; index <= resultEnd; index++)
				System.out.print(para[index] + " ");
		}
	}
}
