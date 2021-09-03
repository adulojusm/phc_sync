
import org.json.JSONArray;
import org.json.JSONObject;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mathew
 */
public class test {
    //

    public static void main(String[] args) {
        String des = "{\n" +
"   \"headers\":[\n" +
"      {\n" +
"         \"name\":\"event\",\n" +
"         \"column\":\"event\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"enrollment\",\n" +
"         \"column\":\"enrollment\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"created\",\n" +
"         \"column\":\"created\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"createdbyuserinfo\",\n" +
"         \"column\":\"createdbyuserinfo\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"lastUpdated\",\n" +
"         \"column\":\"lastUpdated\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"lastUpdatedbyuserinfo\",\n" +
"         \"column\":\"lastUpdatedbyuserinfo\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"storedBy\",\n" +
"         \"column\":\"storedBy\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"completedBy\",\n" +
"         \"column\":\"completedBy\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"completedDate\",\n" +
"         \"column\":\"completedDate\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"eventDate\",\n" +
"         \"column\":\"eventDate\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"dueDate\",\n" +
"         \"column\":\"dueDate\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"orgUnit\",\n" +
"         \"column\":\"orgUnit\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"orgUnitName\",\n" +
"         \"column\":\"orgUnitName\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"status\",\n" +
"         \"column\":\"status\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"programStage\",\n" +
"         \"column\":\"programStage\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"program\",\n" +
"         \"column\":\"program\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"attributeOptionCombo\",\n" +
"         \"column\":\"attributeOptionCombo\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"deleted\",\n" +
"         \"column\":\"deleted\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"geometry\",\n" +
"         \"column\":\"geometry\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"CfIjmVobuul\",\n" +
"         \"column\":\"Vaccine Batch No\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"jrAmide1AOg\",\n" +
"         \"column\":\"Vaccine Expiry Date\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      },\n" +
"      {\n" +
"         \"name\":\"c7FAZD2q7nJ\",\n" +
"         \"column\":\"Vaccine Type\",\n" +
"         \"type\":\"java.lang.String\",\n" +
"         \"hidden\":false,\n" +
"         \"meta\":false\n" +
"      }\n" +
"   ],\n" +
"   \"metaData\":{\n" +
"      \n" +
"   },\n" +
"   \"rows\":[\n" +
"      [\n" +
"         \"Q2jfFio7VDy\",\n" +
"         \"OVX7ERKyO6P\",\n" +
"         \"2021-08-23 00:58:03.583\",\n" +
"         \"{\\\"id\\\": 62342, \\\"uid\\\": \\\"IjfmswLzJat\\\", \\\"surname\\\": \\\"ICT\\\", \\\"username\\\": \\\"nphcda_admin\\\", \\\"firstName\\\": \\\"ADMIN\\\"}\",\n" +
"         \"2021-08-25 22:26:02.16\",\n" +
"         \"{\\\"id\\\": 62342, \\\"uid\\\": \\\"IjfmswLzJat\\\", \\\"surname\\\": \\\"ICT\\\", \\\"username\\\": \\\"nphcda_admin\\\", \\\"firstName\\\": \\\"ADMIN\\\"}\",\n" +
"         \"nphcda_admin\",\n" +
"         \"\",\n" +
"         \"\",\n" +
"         \"2021-08-03 00:00:00.0\",\n" +
"         \"2021-08-23 00:00:00.0\",\n" +
"         \"NIDzPeijaA4\",\n" +
"         \"fc Abuja Clinic\",\n" +
"         \"ACTIVE\",\n" +
"         \"Lvco0jftWeD\",\n" +
"         \"FEgBDv3xyCw\",\n" +
"         \"HllvX50cXC0\",\n" +
"         \"false\",\n" +
"         \"\",\n" +
"         \"77777777\",\n" +
"         \"2021-10-21\",\n" +
"         \"as\"\n" +
"      ],\n" +
"      [\n" +
"         \"T6zBIzwwMud\",\n" +
"         \"OVX7ERKyO6P\",\n" +
"         \"2021-08-20 18:36:27.81\",\n" +
"         \"{\\\"id\\\": 62342, \\\"uid\\\": \\\"IjfmswLzJat\\\", \\\"surname\\\": \\\"ICT\\\", \\\"username\\\": \\\"nphcda_admin\\\", \\\"firstName\\\": \\\"ADMIN\\\"}\",\n" +
"         \"2021-08-25 22:51:47.123\",\n" +
"         \"{\\\"id\\\": 62342, \\\"uid\\\": \\\"IjfmswLzJat\\\", \\\"surname\\\": \\\"ICT\\\", \\\"username\\\": \\\"nphcda_admin\\\", \\\"firstName\\\": \\\"ADMIN\\\"}\",\n" +
"         \"nphcda_admin\",\n" +
"         \"\",\n" +
"         \"2021-08-20 00:00:00.0\",\n" +
"         \"2021-08-18 00:00:00.0\",\n" +
"         \"2021-08-20 00:00:00.0\",\n" +
"         \"NIDzPeijaA4\",\n" +
"         \"fc Abuja Clinic\",\n" +
"         \"COMPLETED\",\n" +
"         \"Lvco0jftWeD\",\n" +
"         \"FEgBDv3xyCw\",\n" +
"         \"HllvX50cXC0\",\n" +
"         \"false\",\n" +
"         \"\",\n" +
"         \"88888888\",\n" +
"         \"2021-09-17\",\n" +
"         \"as\"\n" +
"      ],\n" +
"      [\n" +
"         \"KHwDuHvh80O\",\n" +
"         \"OVX7ERKyO6P\",\n" +
"         \"2021-08-20 20:58:26.679\",\n" +
"         \"{\\\"id\\\": 62342, \\\"uid\\\": \\\"IjfmswLzJat\\\", \\\"surname\\\": \\\"ICT\\\", \\\"username\\\": \\\"nphcda_admin\\\", \\\"firstName\\\": \\\"ADMIN\\\"}\",\n" +
"         \"2021-08-20 20:58:26.679\",\n" +
"         \"{\\\"id\\\": 62342, \\\"uid\\\": \\\"IjfmswLzJat\\\", \\\"surname\\\": \\\"ICT\\\", \\\"username\\\": \\\"nphcda_admin\\\", \\\"firstName\\\": \\\"ADMIN\\\"}\",\n" +
"         \"nphcda_admin\",\n" +
"         \"\",\n" +
"         \"\",\n" +
"         \"2021-08-21 00:00:00.0\",\n" +
"         \"2021-08-20 20:58:26.679\",\n" +
"         \"NIDzPeijaA4\",\n" +
"         \"fc Abuja Clinic\",\n" +
"         \"ACTIVE\",\n" +
"         \"Lvco0jftWeD\",\n" +
"         \"FEgBDv3xyCw\",\n" +
"         \"HllvX50cXC0\",\n" +
"         \"false\",\n" +
"         \"\",\n" +
"         \"55555555\",\n" +
"         \"2021-08-21\",\n" +
"         \"as\"\n" +
"      ]\n" +
"   ],\n" +
"   \"width\":22,\n" +
"   \"height\":3,\n" +
"   \"headerWidth\":22\n" +
"}";
        
        
        
        
        
        try {
            JSONObject obj_ev = new JSONObject(des);
            JSONArray arr_ev = obj_ev.getJSONArray("rows");
            
             for (int i = 0; i < arr_ev.length(); i++) {
                 String batno = arr_ev.getJSONArray(i).getString(19);
             
                 System.out.println("---------------");
                 System.out.println(batno);
             
             
             
             }
            
            
            
        }finally{}
    }
}
