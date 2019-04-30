package com.fwahyudianto.learn.president.models;

import java.util.ArrayList; //  Added

/**
 *  This software, all associated documentation, and all copies are CONFIDENTIAL INFORMATION of Kalpawreska Teknologi Indonesia
 *  http://www.fwahyudianto.id
 *  ® Wahyudianto, Fajar
 *  Email 	: fwahyudi06@gmail.com
 */

public class PresidentData {
    public static String[][] data = new String[][]{
            {"Soekarno", "First President of the Republic of Indonesia", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Presiden_Sukarno.jpg/418px-Presiden_Sukarno.jpg"},
            {"Soeharto", "Second President of the Republic of Indonesia", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/President_Suharto%2C_1993.jpg/468px-President_Suharto%2C_1993.jpg"},
            {"Bacharuddin Jusuf Habibie", "The Third President of the Republic of Indonesia", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Bacharuddin_Jusuf_Habibie_official_portrait.jpg/520px-Bacharuddin_Jusuf_Habibie_official_portrait.jpg"},
            {"Abdurrahman Wahid", "The Fourth President of the Republic of Indonesia", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/President_Abdurrahman_Wahid_-_Indonesia.jpg/486px-President_Abdurrahman_Wahid_-_Indonesia.jpg"},
            {"Megawati Soekarnoputri", "The Fifth President of the Republic of Indonesia", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/President_Megawati_Sukarnoputri_-_Indonesia.jpg/540px-President_Megawati_Sukarnoputri_-_Indonesia.jpg"},
            {"Susilo Bambang Yudhoyono", "Sixth President of the Republic of Indonesia", "https://upload.wikimedia.org/wikipedia/commons/5/58/Presiden_Susilo_Bambang_Yudhoyono.png"},
            {"Joko Widodo", "Seventh President of the Republic of Indonesia", "https://upload.wikimedia.org/wikipedia/commons/1/1c/Joko_Widodo_2014_official_portrait.jpg"}
    };

    public static ArrayList<President> List(){
        President oPresident = null;
        ArrayList<President> lsPresident = new ArrayList<>();
        for (String[] item : data) {
            oPresident = new President();
            oPresident.setPresidentName(item[0]);
            oPresident.setPhoto(item[2]);
            oPresident.setDescriptions(item[1]);

            lsPresident.add(oPresident);
        }

        return lsPresident;
    }
}
