package com.cms.importexport.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.stereotype.Component;

@Component
public class FileExport {

	public static void main(String[] args) throws Exception {
		FileExport zf = new FileExport();

		// Use the following paths for windows
		// String folderToZip = "c:\\demo\\test";
		// String zipName = "c:\\demo\\test.zip";

		// Linux/mac paths
		String folderToZip = "C://Users//User//Desktop//Test";
		String zipName = "C://Users//User//Desktop//Test2.zip";
		// zf.zipFolder(Paths.get(folderToZip), Paths.get(zipName));
	}

	// Uses java.util.zip to create zip file
	public void zipFolder(String src, String dest) throws Exception {
		Path sourceFolderPath = Paths.get(src);
		Path zipPath = Paths.get(dest);
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));
		Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() {
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				zos.putNextEntry(new ZipEntry(sourceFolderPath.relativize(file).toString()));
				Files.copy(file, zos);
				zos.closeEntry();
				return FileVisitResult.CONTINUE;
			}
		});
		zos.close();
	}

	public String tradingFileNameGenerated(String code, String batchSeq) {
		String pattern = "ddMMyyyy";
		String dateInString = new SimpleDateFormat(pattern).format(new Date());
		String fileName = "" + code + "_" + dateInString + "_" + batchSeq;
		return fileName;
	}

	public String NsdlFileNameGenerated(String batchNumber) {

		String fileName = batchNumber;
		return fileName;
	}
	
	
}
