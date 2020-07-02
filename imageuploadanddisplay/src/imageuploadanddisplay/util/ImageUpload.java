package imageuploadanddisplay.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUpload {

	public void saveImage(InputStream imageInputStream, String location, String imageName) {

		// in application - I want to create images directory , in image need to saved.

		File imagesDirectory = new File(location + "/images");

		if (!imagesDirectory.exists()) {
			imagesDirectory.mkdir();
		}

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(
					imagesDirectory.getPath() + "/" + imageName + ".jpg");

			byte[] imageBytes = new byte[imageInputStream.available()];

			imageInputStream.read(imageBytes);

			fileOutputStream.write(imageBytes);

			fileOutputStream.flush();

			fileOutputStream.close();
			imageInputStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
