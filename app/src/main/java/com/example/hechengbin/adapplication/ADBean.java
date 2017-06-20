package com.example.hechengbin.adapplication;

import java.util.ArrayList;

/**
 * Created by hechengbin on 2017/5/26.
 */

public class ADBean {

    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public class Context{
        private String md5Key;
        private String modified;
        private ArrayList<String> adImages;

        public String getMd5Key() {
            return md5Key;
        }

        public void setMd5Key(String md5Key) {
            this.md5Key = md5Key;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public ArrayList<String> getAdImages() {
            return adImages;
        }

        public void setAdImages(ArrayList<String> adImages) {
            this.adImages = adImages;
        }
    }
}
