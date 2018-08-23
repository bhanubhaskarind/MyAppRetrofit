package com.work.bhaskar.myappretrofit;

public class ApiUtils {


        private ApiUtils() {}

        public static final String BASE_URL = "https://bb-technology-services.000webhostapp.com/";

        public static APIService getAPIService() {

            return RetroFitClient.getClient(BASE_URL).create(APIService.class);
        }

}
