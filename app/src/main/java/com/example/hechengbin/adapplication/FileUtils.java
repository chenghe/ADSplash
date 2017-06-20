package com.example.hechengbin.adapplication;

import android.util.Log;

import java.io.File;
import java.text.DecimalFormat;

public final class FileUtils {

	
	public static void deleteFileOrDirectory(File fileOrDirectory) {
		if (fileOrDirectory.isDirectory())
			for (File child : fileOrDirectory.listFiles()){
				deleteFileOrDirectory(child);
			}
		fileOrDirectory.delete();
	}
	
	public static String bytesToHuman(long size) {
		long Kb = 1 * 1024;
		long Mb = Kb * 1024;
		long Gb = Mb * 1024;
		long Tb = Gb * 1024;
		long Pb = Tb * 1024;
		long Eb = Pb * 1024;

		if (size < Kb)
			return floatForm(size) + " byte";
		if (size >= Kb && size < Mb)
			return floatForm((double) size / Kb) + " Kb";
		if (size >= Mb && size < Gb)
			return floatForm((double) size / Mb) + " Mb";
		if (size >= Gb && size < Tb)
			return floatForm((double) size / Gb) + " Gb";
		if (size >= Tb && size < Pb)
			return floatForm((double) size / Tb) + " Tb";
		if (size >= Pb && size < Eb)
			return floatForm((double) size / Pb) + " Pb";
		if (size >= Eb)
			return floatForm((double) size / Eb) + " Eb";

		return "???";
	}

	public static String floatForm(double d) {
		return new DecimalFormat("#.##").format(d);
	}

	/**
	 * 生成文件夹
	 * @param filePath
	 */
	public static void makeRootDirectory(String filePath) {
		File file = null;
		try {
			file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
		} catch (Exception e) {
			Log.i("error:", e + "");
		}
	}

	/**
	 *创建文件夹 返回File对象
	 * @param filePath
	 */
	public static File makeRootDirectoryReturn(String filePath) {
		File file = null;
		try {
			file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
		} catch (Exception e) {
			Log.i("error:", e + "");
		}
		return file;
	}
	
}
