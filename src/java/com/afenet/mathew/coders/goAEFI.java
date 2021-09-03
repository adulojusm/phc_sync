package com.afenet.mathew.coders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mathew
 */
public class goAEFI {

     public static String urll = "http://localhost:8080/dhis2/";
   // public static String urll = "https://nphcdaserver.com/dhis2/";

    //  public static void main(String[] args) {
    public static void startWorking() {
        String base_url = urll + "api/sqlViews/WVyqIdzA1Nm/data.json?pageSize=900000";
        String jsonString = getDemAll(base_url);
        JSONObject obj = new JSONObject(jsonString);
        JSONObject obj_t = obj.getJSONObject("listGrid");
        JSONArray arr = obj_t.getJSONArray("rows"); // notice that `"posts": [...]`
        //    System.out.println("JSON = " + jsonString);
        String as = urll+"api/events/query.json?orgUnit=NIDzPeijaA4&programStage=Lvco0jftWeD&program=FEgBDv3xyCw&dataElement=c7FAZD2q7nJ,CfIjmVobuul,jrAmide1AOg&order=eventDate:asc&filter=c7FAZD2q7nJ:LIKE:as";

        String pfizer = urll+"api/events/query.json?orgUnit=NIDzPeijaA4&programStage=Lvco0jftWeD&program=FEgBDv3xyCw&dataElement=c7FAZD2q7nJ,CfIjmVobuul,jrAmide1AOg&order=eventDate:asc&filter=c7FAZD2q7nJ:LIKE:Bio";

        String morde = urll+"api/events/query.json?orgUnit=NIDzPeijaA4&programStage=Lvco0jftWeD&program=FEgBDv3xyCw&dataElement=c7FAZD2q7nJ,CfIjmVobuul,jrAmide1AOg&order=eventDate:asc&filter=c7FAZD2q7nJ:LIKE:mRNA";

        String jj = urll+"api/events/query.json?orgUnit=NIDzPeijaA4&programStage=Lvco0jftWeD&program=FEgBDv3xyCw&dataElement=c7FAZD2q7nJ,CfIjmVobuul,jrAmide1AOg&order=eventDate:asc&filter=c7FAZD2q7nJ:LIKE:John";

        try {
            for (int i = 0; i < arr.length(); i++) {
                double dz = (double) i / arr.length() * 100;

                //////System.out.println(arr.getJSONArray(i).getString(0)+"Percentage done = " + String.format("%.2f", dz) + "%");
                String org_unit = arr.getJSONArray(i).getString(0);
                getEvents(org_unit, as);
                getEvents(org_unit, pfizer);
                getEvents(org_unit, morde);
                getEvents(org_unit, jj);

            }
        } catch (JSONException ex) {
            Logger.getLogger(goAEFI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getEvents(String orgunit, String typ) {

        String base_url = typ;
        String jsonString_ev = getDemAll(base_url);
      //  System.out.println("A :::" + jsonString_ev);
        try {

            JSONObject obj_ev = new JSONObject(jsonString_ev);
            JSONArray arr_ev = obj_ev.getJSONArray("rows");

            /*
            JSONObject obj_ev = new JSONObject(jsonString_ev);
            JSONArray arr_ev = obj_ev.getJSONArray("events"); // notice that `"posts": [...]`
             */
            // System.out.println("_____----------"+arr_ev);
            if (arr_ev.length() > 0) {

                String st = "";
                String st_1 = "";
                String nd = "";
                String nd_1 = "";
                int swct = arr_ev.length();
                // JSONObject def = new JSONObject(arr_ev);

                // int i = 0;
                String expiry = "";
                String batc_no = "";
                String manuf = "";
                String lkk = "";

                String expiry_1 = "";
                String batc_no_1 = "";
                String manuf_1 = "";

                for (int i = 0; i < arr_ev.length(); i++) {

                    /*
                while (i <= arr_ev.length()) {
                    //    System.out.println("wwwwwwwwwwwwwwwwwwwwww  " + arr_ev.getJSONObject(i).getString("eventDate"));
                    JSONObject onj_nx = arr_ev.getJSONObject(i);
                    JSONArray arr_evx = onj_nx.getJSONArray("dataValues"); // notice that `"posts": [...]`
                    for (int w = 0; w < arr_evx.length(); w++) {
                        String delment = arr_evx.getJSONObject(w).getString("dataElement");
                        //  System.out.println("checkin == " + delment);
                        if (null != delment) {
                            switch (delment) {
                                case "c7FAZD2q7nJ":
                                    manuf = arr_evx.getJSONObject(w).getString("value");
                                    break;
                                case "CfIjmVobuul":
                                    batc_no = arr_evx.getJSONObject(w).getString("value");
                                    break;
                                case "jrAmide1AOg":
                                    expiry = arr_evx.getJSONObject(w).getString("value");
                                    break;
                                default:
                                    break;
                            }
                        }

                    }
                     */
                    batc_no = arr_ev.getJSONArray(i).getString(19);
                    expiry = arr_ev.getJSONArray(i).getString(20);
                    manuf = arr_ev.getJSONArray(i).getString(21);

                    System.out.println("---------------");
                    System.out.println(i + ". picked data are: " + manuf + " " + batc_no + " " + expiry);

                    String event_date_ = arr_ev.getJSONArray(i).getString(9);
                    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss.S", Locale.ENGLISH);
                    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
                    LocalDate date = LocalDate.parse(event_date_, inputFormatter);

                    String event_date = outputFormatter.format(date);
                    String event_date1 = outputFormatter.format(date.minusDays(1));
                    System.out.println(i + ". eventDate: are between " + event_date + " to  " + event_date1);
                    //System.out.println(i + "_________________" + (swct - 1));
                    if (i == 0 && 1 == swct) {
                        // 
                        st = event_date;

                        getVaccinationEventsFirst_Last(orgunit, st, manuf, batc_no, expiry);
                        System.out.println("!!!!xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx!!!! = " + st);
                        return;
                    } else if (i == 0) {
                        st = event_date;
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!! = " + st);
                        lkk = "1";

                    } else if ((swct - 1) == i) {
                        nd_1 = event_date1;
                        nd = event_date;

                        //fire first shot st and nd now availanle
                        System.out.println("FINAL ROUND >>>>>");
                        System.out.println(st_1 + " ONLY 2 and last lopper = " + nd_1 + " using: " + batc_no_1 + "  ++  " + expiry_1);
                        getVaccinationEvents(orgunit, st_1, nd_1, manuf_1, batc_no_1, expiry_1);
                        System.out.println(nd + " and above " + batc_no + "  ++++ " + expiry);
                        getVaccinationEventsFirst_Last(orgunit, nd, manuf, batc_no, expiry);

                        return;
                    } else if (i == 1) {

                        //rund the rest of the code here
                        st = event_date;
                        nd_1 = event_date1;

                        System.out.println(st_1 + " 2nd and continoues lopper is between = " + nd_1 + " using:  " + batc_no_1);
                        getVaccinationEvents(orgunit, st_1, nd_1, manuf_1, batc_no_1, expiry_1);
                    } else {

                        //rund the rest of the code here
                        st = event_date;
                        nd_1 = event_date1;

                        System.out.println(st_1 + " main lopper = " + nd_1);
                        getVaccinationEvents(orgunit, st_1, nd_1, manuf_1, batc_no_1, expiry_1);
                    }

                    batc_no_1 = batc_no;
                    manuf_1 = manuf;
                    expiry_1 = expiry;
                    st_1 = st;

                    expiry = "";
                    batc_no = "";
                    manuf = "";

                  
                }
                swct = 0;
            }
        } catch (JSONException ex) {
            Logger.getLogger(goAEFI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getVaccinationEventsFirst_Last(String orgunit, String dt1, String manufd, String batc_no, String expiry) {
        //retrieve trackedentity id and all vaccination events in each orgunits that are associated with the current event/supplychain in the runn
        String base_url = urll + "api/events.json?orgUnit=" + orgunit + "&program=gWuxRU2yJ1x&programStage=KPc2vZ0IyiH&fields=trackedEntityInstance,event,eventDate,dataValues[value,dataElement]&order=eventDate:asc&startDate=" + dt1;
        String json_value = getDemAll(base_url);
        System.out.println(manufd+"   ...DATA_URL_Vacc_Events" + base_url);

        try {
            if (json_value.contains("event\":")) {

                // String json_value = "{\"pager\":{\"page\":1,\"pageCount\":1,\"total\":0,\"pageSize\":50},\"events\":[{\"event\":\"vXN9KgUhQnE\",\"trackedEntityInstance\":\"LHsK7AB0bDJ\",\"eventDate\":\"2021-08-17T00:00:00.000\",\"dataValues\":[{\"dataElement\":\"c7FAZD2q7nJ\",\"value\":\"as\"},{\"dataElement\":\"LavUrktwH5D\",\"value\":\"https://\"},{\"dataElement\":\"LUIsbsm3okG\",\"value\":\"DOSE1\"},{\"dataElement\":\"wOyOg4cO6uO\",\"value\":\"true\"},{\"dataElement\":\"vqg9zD9AOhR\",\"value\":\"2021-10-16\"}]}]}";
                JSONObject obj_vacc = new JSONObject(json_value);

                JSONArray arr_vacc = obj_vacc.getJSONArray("events"); // notice that `"posts": [...]`

                //System.out.println(arr_vacc);
                int i = 0;

                String manuf = "";
                String dos_ = "";
                String vaccd = "";

                //    ////System.out.println("**********444444444444444444444*************" + arr_vacc.length());
                while (i < arr_vacc.length()) {

                    JSONObject onj_nx = arr_vacc.getJSONObject(i);
                    JSONArray arr_evx = onj_nx.getJSONArray("dataValues"); // notice that `"posts": [...]`
                    // //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$++++++++++++++++++++$$$$$$$$$$$$$$$" + arr_evx.length());
                    if (arr_evx.length() != 0) {
                        for (int w = 0; w < arr_evx.length(); w++) {
                            String delment = arr_evx.getJSONObject(w).getString("dataElement");
                            //  ////System.out.println("checkin == " + delment);
                            if (null != delment) {
                                switch (delment) {
                                    case "c7FAZD2q7nJ":
                                        manuf = arr_evx.getJSONObject(w).getString("value");
                                        break;
                                    case "LUIsbsm3okG":
                                        dos_ = arr_evx.getJSONObject(w).getString("value");
                                        break;
                                    /*   case "wOyOg4cO6uO":
                                vaccd = arr_evx.getJSONObject(w).getString("value");
                                break;
                                     */
                                    default:
                                        break;
                                }
                            }

                        }
                        ////System.out.println("Vacccination data are: " + manuf + " " + dos_);
                        if (manuf.equalsIgnoreCase(manufd)) {
                            String tracked_entity = arr_vacc.getJSONObject(i).getString("trackedEntityInstance");
                            //  ////System.out.println("++++8888888888888888888++++++" + arr_vacc.toString());
                            String eventDate = arr_vacc.getJSONObject(i).getString("eventDate");
                            ////System.out.println(eventDate + " == Tracker = " + tracked_entity);
                            updateTrackerEntitywithValue(orgunit, dos_, manufd, batc_no, expiry, tracked_entity, eventDate);
                        }
                    }
                    i++;

                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(goAEFI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void getVaccinationEvents(String orgunit, String dt1, String dt2, String manufd, String batc_no, String expiry) {
       // if(1==2){
        //return;}
        //retrieve trackedentity id and all vaccination events in each orgunits that are associated with the current event/supplychain in the runn
        try {
            String base_url = urll + "api/events.json?orgUnit=" + orgunit + "&program=gWuxRU2yJ1x&programStage=KPc2vZ0IyiH&fields=trackedEntityInstance,event,eventDate,dataValues[value,dataElement]&order=eventDate:asc&startDate=" + dt1 + "&endDate=" + dt2;
            String json_value = getDemAll(base_url);
            System.out.println(manufd+"   ...DATA_URL_Vacc_Events" + base_url);

            if (json_value.contains("event\":")) {

                // String json_value = "{\"pager\":{\"page\":1,\"pageCount\":1,\"total\":0,\"pageSize\":50},\"events\":[{\"event\":\"vXN9KgUhQnE\",\"trackedEntityInstance\":\"LHsK7AB0bDJ\",\"eventDate\":\"2021-08-17T00:00:00.000\",\"dataValues\":[{\"dataElement\":\"c7FAZD2q7nJ\",\"value\":\"as\"},{\"dataElement\":\"LavUrktwH5D\",\"value\":\"https://\"},{\"dataElement\":\"LUIsbsm3okG\",\"value\":\"DOSE1\"},{\"dataElement\":\"wOyOg4cO6uO\",\"value\":\"true\"},{\"dataElement\":\"vqg9zD9AOhR\",\"value\":\"2021-10-16\"}]}]}";
                JSONObject obj_vacc = new JSONObject(json_value);
                JSONArray arr_vacc = obj_vacc.getJSONArray("events"); // notice that `"posts": [...]`

                //   ////System.out.println(arr_vacc);
                int i = 0;

                String manuf = "";
                String dos_ = "";
                String vaccd = "";
                // //System.out.println("******************************************" + arr_vacc.length());

                while (i < arr_vacc.length()) {

                    JSONObject onj_nx = arr_vacc.getJSONObject(i);
                    JSONArray arr_evx = onj_nx.getJSONArray("dataValues"); // notice that `"posts": [...]`
                    //  ////System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + arr_evx.length());
                    for (int w = 0; w < arr_evx.length(); w++) {
                        String delment = arr_evx.getJSONObject(w).getString("dataElement");
                        ////System.out.println("checkin == " + delment);
                        if (null != delment) {
                            switch (delment) {
                                case "c7FAZD2q7nJ":
                                    manuf = arr_evx.getJSONObject(w).getString("value");
                                    break;
                                case "LUIsbsm3okG":
                                    dos_ = arr_evx.getJSONObject(w).getString("value");
                                    break;
                                /*   case "wOyOg4cO6uO":
                                vaccd = arr_evx.getJSONObject(w).getString("value");
                                break;
                                 */
                                default:
                                    break;
                            }
                        }

                    }
                    ////System.out.println("Vacccination data are: " + manuf + " " + dos_);
                    if (manuf.equalsIgnoreCase(manufd)) {
                        String tracked_entity = arr_vacc.getJSONObject(i).getString("trackedEntityInstance");
                        //   ////System.out.println("++++++++++++++++++++++" + arr_vacc.toString());
                        String eventDate = arr_vacc.getJSONObject(i).getString("eventDate");
                        ////System.out.println(eventDate + " == Tracker = " + tracked_entity);
                        updateTrackerEntitywithValue(orgunit, dos_, manufd, batc_no, expiry, tracked_entity, eventDate);
                    }
                    i++;

                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(goAEFI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateTrackerEntitywithValue(String orgunit, String dos, String man_supp, String bat_no, String expy, String track_id, String ev_date) {
        //update record at this point
        String base_url = urll + "api/trackedEntityInstances/" + track_id + "?ignoreEmptyCollection=true";
        String valu = "{\"orgUnit\": \"" + orgunit + "\",\"attributes\": [{\"attribute\": \"abShqMWeo8B\",\"value\": \"" + man_supp + "\"},{\"attribute\": \"HRNihmNi5ZJ\",\"value\": \"" + bat_no + "\"},{\"attribute\": \"wAe7mBoDwiW\",\"value\": \"" + expy + "\"},{\"attribute\": \"Rcead3EVONa\",\"value\": \"" + ev_date + "\"}]}";

        putDemAll(base_url, valu);

    }

    public static String getDemAll(String pg_url) {
    //    System.out.println(":::::::: "+pg_url);

        HttpURLConnection urlConnection = null;
        String name = "aefi_reporter_ROBOT";
        String password = "Passcode123!";
        StringBuilder sb = new StringBuilder();

        String authString = name + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        try {
            URL url = new URL(pg_url);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("GET");
            urlConnection.setUseCaches(true);
            urlConnection.setConnectTimeout(2000);
            urlConnection.setReadTimeout(2000);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            int HttpResult = urlConnection.getResponseCode();
            //debug  
            // ////System.out.println("######cccccccccccc####Outreach Session HTTP Return Code = " + HttpResult);

            if (HttpResult == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                //debug  ////System.out.println("#########AAA###" + sb.toString());
                if (sb.toString().indexOf("success") >= 1) {
                    //      response.setStatus(200);
                    System.err.println("DATA: Success!");
                    return sb.toString();
                }
                if (sb.toString().indexOf("warning") >= 1) {
                    //        response.setStatus(300);
                    System.err.println("DATA: Warning!");
                    return sb.toString();
                }
                if ((sb.toString().indexOf("warning") >= 1) || (sb.toString().indexOf("success") >= 1)) {
                    //      response.setStatus(414);
                    System.err.println("Noticable Error:\n" + sb.toString());
                    return sb.toString();
                }
            } else {
                //response.setStatus(502, "DHIS2 Not there!");
                ////System.out.println("####CCCCCCCCCCCCCC" + urlConnection.getInputStream().toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                ////System.out.println("#####XXX##" + sb.toString());
                ////System.out.println("OUT ERROR:>>>>" + urlConnection.getResponseMessage());
                return sb.toString();
            }

        } catch (IOException ex) {
            Logger.getLogger(goAEFI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        //  ////System.out.println(sb.toString());
        return sb.toString();
    }

    public static void putDemAll(String pg_url, String valu) {

        HttpURLConnection urlConnection = null;
        String name = "aefi_reporter_ROBOT";
        String password = "Passcode123!";
        StringBuilder sb = new StringBuilder();
        //System.out.println(pg_url);

        String authString = name + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        try {
            URL url = new URL(pg_url);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("PUT");
            urlConnection.setUseCaches(true);
            urlConnection.setConnectTimeout(2000);
            urlConnection.setReadTimeout(2000);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(valu);
            out.close();

            int HttpResult = urlConnection.getResponseCode();
            //debug  
            //  System.out.println("Data session HTTP Return Code = " + HttpResult);

            if (HttpResult == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                //debug  ////System.out.println("#########AAA###" + sb.toString());
                if (sb.toString().indexOf("success") >= 1) {
                    //      response.setStatus(200);
                    System.err.println("DATA: Success!");
                    return;
                }
                if (sb.toString().indexOf("warning") >= 1) {
                    //        response.setStatus(300);
                    System.err.println("Warning!");
                    return;
                }
                if (sb.toString().indexOf("conflict") >= 1) {
                    //        response.setStatus(300);
                    System.err.println("Conflicts!");
                    return;
                }
                if ((sb.toString().indexOf("warning") >= 1) || (sb.toString().indexOf("success") >= 1)) {
                    //      response.setStatus(414);
                    System.err.println("Noticable Error:\n" + sb.toString());
                    return;
                }
            } else {
                //response.setStatus(502, "DHIS2 Not there!");
                ////System.out.println("####CCCCCCCCCCCCCC" + urlConnection.getInputStream().toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                ////System.out.println("#####XXX##" + sb.toString());
                ////System.out.println("OUT ERROR:>>>>" + urlConnection.getResponseMessage());
                return;
            }

        } catch (IOException ex) {
            Logger.getLogger(goAEFI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        //  ////System.out.println(sb.toString());
    }
}
