package ku.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileUtil {
	/**
	 * Copy file 1 byte at a time.
	 * 
	 * @param in
	 *            is the InputStream of the file to be read
	 * @param out
	 *            is the OutputStream of the file to be written
	 */
	public static void copy(InputStream in, OutputStream out) {
		try {
			int readByte;
			try {
				while ((readByte = in.read()) != -1) {

					out.write(readByte);
				}
			} finally {
				in.close();
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Copy file with a specific bytes at a time.
	 * 
	 * @param in
	 *            is the InputStream of the file to be read
	 * @param out
	 *            is the OutputStream of the file to be written
	 * @param blocksize
	 *            is how many bytes to be copied at a time
	 */
	public static void copy(InputStream in, OutputStream out, int blocksize) {
		try {
			byte[] buffer = new byte[blocksize];
			int length;
			try {
				while ((length = in.read(buffer)) != -1) {
					out.write(buffer, 0, length);
				}
			} finally {
				in.close();
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Copy file one line at a time using BufferedReader and PrintWriter.
	 * 
	 * @param in
	 *            is the InputStream used for reading
	 * @param out
	 *            is the OutputStream used for writing
	 */
	public static void bcopy(InputStream in, OutputStream out) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			PrintWriter writer = new PrintWriter(out);
			String line;
			try {
				while ((line = reader.readLine()) != null) {
					writer.println(line);
				}
			} finally {
				writer.close();
				reader.close();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Copy file with a specific number of characters using BufferedReader and
	 * PrintWriter.
	 * 
	 * @param in
	 *            is the InputStream used for reading
	 * @param out
	 *            is the OutputStream used for writing
	 * @param blocksize
	 *            is the size of char array to be read at a time
	 */
	public static void ccopy(InputStream in, OutputStream out, int blocksize) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
			char[] buffer = new char[blocksize];
			int len;
			try {
				while ((len = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, len);
				}
			} finally {
				writer.close();
				reader.close();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
