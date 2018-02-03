package hackers.com.project;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by on 16/02/16.
 */
public class WSLogin {
    private Context context;
    private String message;
    private boolean success;


    public WSLogin(final Context context) {
        this.context = context;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
    /**
     * Method to execute service and parse response.
     */
    public void executeService(final String email, final String password) {
        final String url = WSConstants.BASE_URL + WSConstants.METHOD_LOGIN;
        final String response = new WSUtil().callServiceHttpPost(url, generateLoginRequest(email, password));
        parseResponse(response);
    }

    /* Parse the json response in string.
      *
      * @param response
      */
    private void parseResponse(final String response) {
        if (response != null && response.trim().length() > 0) {
            try {
                final JSONObject jsonObject = new JSONObject(response);
                final WSConstants wsConstants = new WSConstants();
                if (jsonObject != null && jsonObject.length() > 0) {
                        success = jsonObject.optInt(wsConstants.PARAMS_RESPONSE) == 0;
                        message = jsonObject.optString(wsConstants.PARAMS_SUCCESS);
                        if (success) {
                            final JSONObject jsonObjectData = jsonObject.optJSONObject(wsConstants.PARAMS_RESULT);
                            if (jsonObjectData != null && jsonObjectData.length() > 0) {
                                final String id = jsonObjectData.optString(wsConstants.PARAMS_ID);
                                Log.d("TAG",id);
                            }
                        }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Generate RequestBody.
     */
    private RequestBody generateLoginRequest(final String email, final String password) {
        final WSConstants wsConstants = new WSConstants();
        final FormBody.Builder formEncodingBuilder = new FormBody.Builder();
        formEncodingBuilder.add(wsConstants.PARAMS_EMAIL, email);
        formEncodingBuilder.add(wsConstants.PARAMS_PASSWORD, password);
        return formEncodingBuilder.build();
    }

}
