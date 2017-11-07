package sk.project22.plugins;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import javax.imageio.IIOImage;
import java.awt.image.BufferedImage;

public class ImageDetails extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

    if ("resolution".equals(action)) {
      JSONObject parameters = args.getJSONObject(0);
      
      if (parameters != null) {
        BufferedImage bimg = ImageIO.read(new File(parameters.getString("filePath")));

        JSONObject r = new JSONObject();
        r.put("width", bimg.getWidth());
        r.put("height", bimg.getHeight());

        callbackContext.success(r);

        return true;
      }
    }
    return false;
  }
}
