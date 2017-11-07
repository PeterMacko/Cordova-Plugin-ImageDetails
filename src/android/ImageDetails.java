package sk.project22.plugins;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import android.graphics.BitmapFactory;

public class ImageDetails extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

    if ("resolution".equals(action)) {
      JSONObject parameters = data.getJSONObject(0);
      
      if (parameters != null) {
        BitmapFactory.Options bitMapOption=new BitmapFactory.Options();
        bitMapOption.inJustDecodeBounds=true;
        BitmapFactory.decodeFile(parameters.getString("filePath").replace("file://", ""), bitMapOption);

        JSONObject r = new JSONObject();
        r.put("width", bitMapOption.outWidth);
        r.put("height", bitMapOption.outHeight);

        callbackContext.success(r);

        return true;
      }
    }
    return false;
  }
}
