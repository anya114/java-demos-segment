package com.wxmimperio.kafka.producer;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;

/**
 * Created by wxmimperio on 2016/12/5.
 */
public class ProducerHandle implements Runnable {
    private Producer<String, String> producer;
    private int threadNumber;
    private String topic;

    public ProducerHandle(Producer<String, String> producer, int threadNumber, String topic) {
        this.producer = producer;
        this.threadNumber = threadNumber;
        this.topic = topic;
    }

    @Override
    public void run() {
        int messageNo = 0;
        while (true) {
            Date nowTime = new Date();
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

            String key = String.valueOf(threadNumber);
            //String data = "hello,kafka,message" + messageNo + " " + key + "," + time.format(nowTime);

            //String active_msg_104 = "{\"source_path\": \"/opt/logs/lsc4gauth/auditlog/request_audit.log\",\"service_id\": 55680,\"area_id\": \"-1\",\"idx3\": \"991000801\",\"idx2\": \"862532025733733-b3c76a723b30e0c6\",\"service_id_msg_id\": \"55680_104\",\"error_code\": \"0\",\"type\": \"lsc4gauth\",\"req_str\": \"http_x_app_id:991000801^_^http_x_app_version:1.90^_^http_x_channel:G34^_^data:{\\\"model\\\":\\\"Coolpad 8079\\\",\\\"phoneNumber\\\":\\\"\\\",\\\"metrics\\\":\\\"480*854\\\",\\\"ram\\\":\\\"421\\\",\\\"merchant\\\":\\\"移动 3G\\\",\\\"systemVersion\\\":\\\"4.0.3\\\",\\\"cpu\\\":\\\"armeabi-v7a\\\",\\\"mac\\\":\\\"\\\",\\\"deviceId\\\":\\\"862532025733733\\\",\\\"ipAddress\\\":\\\"0.0.0.0\\\",\\\"storage\\\":\\\"7603\\\"}^_^type:android^_^deviceid:862532025733733-b3c76a723b30e0c6^_^http_x_channel_info:\",\"source_host\": \"127.0.0.1\",\"client_ip\": \"10.116.63.225\",\"timestamp\": \"2017-03-07T12:53:44.823+08:00\",\"proxy_ip\": \"10.158.20.45\",\"duration\": 13,\"request_id\": \"04E9DCCA42188D4E9207EE49FCC0AF2F\",\"res_str\": \"code:0^_^msg:ok^_^result:0^_^message:ok^_^dtime:1488862424^_^model:Coolpad 8079^_^systemversion:4.0.3^_^merchant:移动 3G^_^cpu:armeabi-v7a^_^deviceid:862532025733733^_^storage:7603^_^ram:421^_^metrics:480*854^_^phonenumber:^_^mac:^_^ipaddress:0.0.0.0^_^systemname:^_^localizedmodel:^_^platform:^_^platformstring:\",\"msg_id\": 104,\"soc_name\": \"\",\"app_id\": \"-1\"}\n";

            //String login_msg_2 = "{\"source_path\": \"/opt/logs/lsc4gauth/auditlog/request_audit.log\",\"service_id\": 55680,\"area_id\": \"-1\",\"idx3\": \"859560325885748021488862877\",\"idx2\": \"+86-18115393371\",\"service_id_msg_id\": \"55680_2\",\"idx1\": \"2588574802\",\"error_code\": \"0\",\"type\": \"lsc4gauth\",\"req_str\": \"http_x_app_id:791000035^_^http_x_app_version:4.0.6^_^http_x_channel:GG1746^_^http_x_token:T0C8BD214325E480A8B11A7F689A5A70D^_^http_x_area:^_^phone:+86-18115393371^_^password_length:^_^deviceid:A0000060AE69CD-9106b3ca1f1017f4^_^code:664389^_^http_x_engine:android^_^sdk_x_version:3.3.3.7^_^ua:Dalvik/2.1.0 (Linux; U; Android 5.1.1; OPPO R9 Plusm A Build/LMY47V)^_^http_x_channel_info:^_^group:\",\"source_host\": \"127.0.0.1\",\"client_ip\": \"112.0.104.57\",\"timestamp\": \"2017-03-07T13:01:17.067+08:00\",\"proxy_ip\": \"10.158.20.45\",\"duration\": 62,\"request_id\": \"4096A72C79E770448C01CBCF3F358A03\",\"res_str\": \"code:0^_^msg:ok^_^result:0^_^message:ok^_^userid:2588574802^_^ticket:859560325885748021488862877^_^autokey:AUTOCDA6769A0485484392BCE9C55A2E6B65^_^activation:0^_^lt:^_^ios_channel:^_^ios_mac:^_^ios_idfa:^_^ios_extend:^_^appmid:2588574802^_^clientip:112.0.104.57^_^realinfo_status:0^_^realinfo_force:0\",\"msg_id\": 2,\"soc_name\": \"\",\"app_id\": \"-1\"}";

            //String login_msg_1 = "{\"source_path\": \"/opt/logs/lsc4gauth/auditlog/request_audit.log\",\"service_id\": 55680,\"area_id\": \"-1\",\"idx3\": \"824093610774625081488862808\",\"idx2\": \"+86-18036460372\",\"service_id_msg_id\": \"55680_1\",\"idx1\": \"1077462508\",\"error_code\": \"0\",\"type\": \"lsc4gauth\",\n" +
            //"\"req_str\": \"http_x_app_id:791000128^_^http_x_app_version:1.1003^_^http_x_channel:ios^_^http_x_token:T2256620E0A4743D189676E033625AE8F^_^http_x_area:^_^phone:+86-18036460372^_^password_length:^_^deviceid:671604CD-74E8-4AE5-8018-007D649CD068^_^http_x_engine:ios^_^sdk_x_version:3.2.10^_^ua:Mozilla/5.0 (iPhone; CPU iPhone OS 9_3_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13F69^_^http_x_channel_info:^_^group:\",\"source_host\": \"10.129.20.75\",\"client_ip\": \"180.98.1.173\",\"timestamp\": \"2017-03-07T13:00:08.602+08:00\",\"proxy_ip\": \"10.158.20.47\",\"duration\": 55,\"request_id\": \"F916DC52E63C8544A6FD7C920BF22290\",\"res_str\": \"code:0^_^msg:ok^_^result:0^_^message:ok^_^userid:1077462508^_^ticket:824093610774625081488862808^_^autokey:AUTO278E79EC1A0A40C084059F4BB9A32DE8^_^activation:0^_^lt:^_^ios_channel:^_^ios_mac:^_^ios_idfa:^_^ios_extend:^_^appmid:1077462508^_^pmid:1077462508^_^clientip:180.98.1.173^_^loginuserid:^_^realinfo_status:0^_^realinfo_force:1\",\"msg_id\": 1,\"soc_name\": \"\",\"app_id\": \"-1\"}";

            //String login_msg_3 = "{\"source_path\": \"/opt/logs/lsc4gauth/auditlog/request_audit.log\",\"service_id\": 55680,\"area_id\": \"-1\",\"idx3\": \"AUTO72BA1A77329F4CB3B94F900BF666E9E2\",\"idx2\": \"AUTO235C5EAA967C491280285D7E4C3CA150\",\"service_id_msg_id\": \"55680_3\",\"idx1\": \"957328924\",\"error_code\": \"0\",\"type\": \"lsc4gauth\",\"req_str\": \"http_x_app_id:791000035^_^http_x_app_version:4.0.6^_^http_x_channel:GG103^_^http_x_token:TE41EC1C3819444C8B188D8C585FDE5F9^_^autokey:AUTO235C5EAA967C491280285D7E4C3CA150^_^deviceid:863563023497590-c987fc9493bb4e67^_^http_x_engine:android^_^sdk_x_version:3.3.3.7^_^http_x_area:^_^ua:Dalvik/1.6.0 (Linux; U; Android 4.4.2; Lenovo S898t+ Build/KOT49H)^_^http_x_channel_info:^_^group:\",\"source_host\": \"10.129.20.76\",\"client_ip\": \"58.154.168.133\",\"timestamp\": \"2017-03-07T13:00:12.625+08:00\",\"proxy_ip\": \"10.158.20.44\",\"duration\": 27,\"request_id\": \"A63F9C4DFBC7D44F8C37500083126E5F\",\"res_str\": \"code:0^_^msg:ok^_^result:0^_^message:ok^_^userid:957328924^_^ticket:85396089573289241488862812^_^autokey:AUTO72BA1A77329F4CB3B94F900BF666E9E2^_^activation:0^_^appmid:957328924^_^clientip:58.154.168.133^_^realinfo_status:0^_^realinfo_force:0\",\"msg_id\": 3,\"soc_name\": \"\",\"app_id\": \"-1\"}";

            //String login_msg_13 = "{\"source_path\": \"/opt/logs/lsc4gauth/auditlog/request_audit.log\",\"service_id\": 55680,\"area_id\": \"-1\",\"idx3\": \"819646910222333011488862817\",\"idx2\": \"47240341\",\"service_id_msg_id\": \"55680_13\",\"idx1\": \"1022233301\",\"error_code\": \"0\",\"type\": \"lsc4gauth\",\"req_str\": \"token:TBDF6FAB724D04FBF924F4DEAF6DE0E9E^_^cipher:Fokyw065LiA2Y88rMfQy1ScxzONv3w/b8TdOv4UhFbY0LDA8dtr6Fgxfpv47PRWq^_^sign:AB36B5587F2DAE0E5C25392974D0CCA6^_^appid:991000801^_^thirduserid:47240341^_^companyid:198^_^usertype:28^_^thirdid1:^_^thirdid2:^_^thirdid3:^_^channelcode:G14^_^userip:183.46.168.219^_^areaid:^_^ua:^_^group:\",\"source_host\": \"10.129.20.75\",\"client_ip\": \"10.129.41.149\",\"timestamp\": \"2017-03-07T13:00:17.248+08:00\",\"proxy_ip\": \"10.129.20.82\",\"duration\": 41,\"request_id\": \"B25CE2EDE079DD4086745CB662F9A3D0\",\"res_str\": \"code:0^_^msg:ok^_^ticket:819646910222333011488862817^_^mid:1022233301^_^isfirst:1^_^deviceid:863817031628285-f3b676323656655c^_^userid:1022233301^_^activation:0^_^appmid:1022233301^_^clientip:10.129.41.149^_^realinfo_status:0^_^realinfo_force:1\",\"msg_id\": 13,\"soc_name\": \"\",\"app_id\": \"-1\"}";

            //String login_msg_20 = "{\"source_path\": \"/opt/logs/lsc4gauth/auditlog/request_audit.log\",\"service_id\": 55680,\"area_id\": \"-1\",\"idx3\": \"862632030332412-bec96e8c7be3768b\",\"service_id_msg_id\": \"55680_20\",\"error_code\": \"0\",\"type\": \"lsc4gauth\",\"req_str\": \"http_x_app_id:791000035^_^http_x_app_version:4.0.6^_^http_x_channel:GG1739^_^http_x_token:TFCAD732268CF4072BAC6CFC0DF300499^_^deviceid:862632030332412-bec96e8c7be3768b^_^looptype:2^_^http_x_area:^_^ua:Dalvik/2.1.0 (Linux; U; Android 7.0; FRD-AL10 Build/HUAWEIFRD-AL10)^_^http_x_channel_info:^_^group:\",\"source_host\": \"10.129.20.76\",\"client_ip\": \"117.136.79.200\",\"timestamp\": \"2017-03-07T15:44:52.705+08:00\",\"proxy_ip\": \"10.158.20.44\",\"duration\": 1,\"request_id\": \"BD98BA1BCAF3814E8E874A84A13CEBF7\",\"res_str\": \"code:70^_^msg:尚未接收到短信^_^result:^_^message:^_^userid:144654565^_^ticket:^_^autokey:^_^activation:^_^phone:^_^isfirst:1^_^appmid:^_^smsguid:^_^registered:^_^phone:^_^displayacc:^_^tip:^_^clientip:117.136.79.200^_^realinfo_status:^_^realinfo_force:\",\"msg_id\": 20,\"soc_name\": \"\",\"app_id\": \"-1\"}";

            //String pt_login_50001_1 = "{\"source_path\": \"/opt/logs/asc/auditlog/request_audit.log\",\"service_id\": 50001,\"area_id\": \"181\",\"idx3\": \"wq00684510290.pt\",\"idx2\": \"Ca20sq0q\",\"service_id_msg_id\": \"50001_1\",\"idx1\": \"3489444721\",\"req_endpointip\": \"183.140.86.238\",\"error_code\": \"0\",\"type\": \"asc\",\"req_str\": \"loginaccount:Ca20sq0q^_^endpointip:183.140.86.238^_^appid:4^_^areaid:181^_^ulsfweb:^_^productid:11^_^productversion:2.1.0.0^_^ascommand:11^_^macid:53-DC-B9-80-6D-AC^_^needcheckuserlogin:^_^authensource:55103^_^deviceid:\",\"source_host\": \"10.129.20.146\",\"client_ip\": \"150.242.59.171\",\"timestamp\": \"2017-03-18T13:48:13.057+08:00\",\"proxy_ip\": \"10.129.20.75\",\"duration\": 34,\"request_id\": \"467338073A0F41718E2460010D946570\",\"res_str\": \"isneeddeviceauthen:0^_^loginsndaid:3489444721^_^ptid:wq00684510290.pt^_^gameapp:|6|7|^_^safedevicetypearray:^_^safedeviceserialnoarray:^_^safedeviceapplytypearray:^_^bindenablearray:^_^logintype:1^_^mastersndaid:^_^verifysndaid:^_^ismobileaccount:0^_^userattribute:0^_^mobile:^_^userloginplacecode:0^_^userremotetype:1^_^loginriskcheckresult:^_^isuserregularposition:0^_^region_id:1156330400^_^prompt:^_^deviceid:53-DC-B9-80-6D-AC\",\"msg_id\": 1,\"soc_name\": \"30653\",\"app_id\": \"4\"}";

            //String pt_login_50001_5 = "{\"source_path\": \"/opt/logs/asc/auditlog/request_audit.log\",\"service_id\": 50001,\"area_id\": \"0\",\"idx3\": \"zd00114786428.pt\",\"idx2\": \"1989845134\",\"service_id_msg_id\": \"50001_5\",\"idx1\": \"1989845134\",\"req_endpointip\": \"182.103.18.20\",\"error_code\": \"0\",\"type\": \"asc\",\"req_str\": \"loginaccount:1989845134^_^endpointip:182.103.18.20^_^appid:241^_^areaid:0^_^ulsfweb:20^_^productid:2^_^productversion:v5^_^ascommand:2^_^trustlogintype:6^_^displayaccount:lzq271093531@163.com^_^ptid:^_^deviceid:\",\"source_host\": \"10.129.65.20\",\"client_ip\": \"182.103.18.20\",\"timestamp\": \"2017-03-18T13:48:14.803+08:00\",\"proxy_ip\": \"10.129.20.16\",\"duration\": 34,\"request_id\": \"8436E51844F7D74299C38F48864D11C7\",\"res_str\": \"isneeddeviceauthen:0^_^loginsndaid:1989845134^_^ptid:zd00114786428.pt^_^gameapp:|6|7|^_^safedevicetypearray:^_^safedeviceserialnoarray:^_^safedeviceapplytypearray:^_^bindenablearray:^_^mastersndaid:^_^verifysndaid:^_^ismobileaccount:0^_^mobile:^_^companyid:^_^userloginplacecode:-16027516^_^userremotetype:1^_^loginriskcheckresult:^_^isuserregularposition:0^_^region_id:1156360000^_^prompt:\",\"msg_id\": 5,\"soc_name\": \"\",\"app_id\": \"241\"}";

            //String pt_login_50002_1 = "{\"source_path\": \"/opt/logs/asc/auditlog/request_audit.log\",\"service_id\": 50002,\"area_id\": \"8\",\"idx3\": \"nc00668305542.pt\",\"idx2\": \"3473239683\",\"service_id_msg_id\": \"50002_1\",\"idx1\": \"3473239683\",\"req_endpointip\": \"171.221.207.79\",\"error_code\": \"0\",\"res_sndaid\": \"3473239683\",\"type\": \"asc\",\"req_str\": \"loginaccount:3473239683^_^password:A3|G10|F15^_^authmethod:3^_^challengeno:^_^safedevicetype:2^_^endpointip:171.221.207.79^_^appid:89^_^areaid:8^_^ignore_blackip:\",\"source_host\": \"10.129.20.145\",\"client_ip\": \"171.221.207.79\",\"timestamp\": \"2017-03-18T13:51:59.993+08:00\",\"proxy_ip\": \"10.129.20.78\",\"duration\": 27,\"request_id\": \"5D5AB179F916964EB0282314FA2C2042\",\"res_str\": \"sndaid:3473239683^_^ptid:nc00668305542.pt^_^verifysndaid:^_^check_result:1\",\"msg_id\": 1,\"soc_name\": \"\",\"app_id\": \"89\"}";

            //String pt_login_50002_2 = "{\"source_path\": \"/opt/logs/asc/auditlog/request_audit.log\",\"service_id\": 50002,\"area_id\": \"607\",\"idx3\": \"1105089946.sdo\",\"idx2\": \"1105089946.sdo\",\"service_id_msg_id\": \"50002_2\",\"idx1\": \"1105089946\",\"req_endpointip\": \"125.111.44.166\",\"error_code\": \"0\",\"res_sndaid\": \"1105089946\",\"type\": \"asc\",\"req_str\": \"loginaccount:1105089946.sdo^_^authmethod:2^_^challengeno:12345^_^endpointip:125.111.44.166^_^appid:106^_^areaid:607^_^ignore_blackip:1\",\"source_host\": \"10.129.65.11\",\"client_ip\": \"116.211.1.100\",\"timestamp\": \"2017-03-18T12:48:43.870+08:00\",\"proxy_ip\": \"10.129.20.76\",\"duration\": 29,\"request_id\": \"189BB1D182584DDF9AB811458BE0F840\",\"res_str\": \"sndaid:1105089946^_^ptid:1105089946.sdo^_^gameapp:\",\"msg_id\": 2,\"soc_name\": \"28207\",\"app_id\": \"106\"}";

            //String pt_login_50003_1 = "{\"source_path\": \"/opt/logs/asc/auditlog/request_audit.log\",\"service_id\": 50003,\"area_id\": \"1\",\"idx3\": \"sl00221504945.pt\",\"idx2\": \"sl00221504945.pt\",\"service_id_msg_id\": \"50003_1\",\"idx1\": \"3202317298\",\"error_code\": \"0\",\"type\": \"asc\",\"req_str\": \"loginaccount1:sl00221504945.pt^_^endpointip1:120.37.65.231^_^appid:11^_^areaid:1\",\"source_host\": \"10.129.20.146\",\"client_ip\": \"180.96.32.38\",\"timestamp\": \"2017-03-18T13:48:19.435+08:00\",\"proxy_ip\": \"10.129.28.44\",\"duration\": 65,\"request_id\": \"2D9C117F260F46CEB6198541D9B1CD63\",\"res_str\": \"isneeddeviceauthen:0^_^loginsndaid1:3202317298^_^ptid1:sl00221504945.pt^_^safedevicetypearray1:^_^safedeviceserialnoarray1:^_^safedeviceapplytypearray1:^_^mastersndaid1:^_^verifysndaid1:^_^ismobileaccount1:1^_^userattribute1:0^_^mobile1:13886163535\",\"msg_id\": 1,\"soc_name\": \"\",\"app_id\": \"4034\"}";

            //String mobile_deposit = "{\"source_path\":\"/opt/logs/gwalletorder/auditlog/request_audit.log\",\"service_id\":220,\"area_id\":\"0\",\"service_id_msg_id\":\"220_2\",\"error_code\":\"0\",\"type\":\"gwalletorder\",\"req_str\":\"reqOrderNo:gjiabreak_845859111466696704^_^orderNo:791000136PP015170324194852000002^_^orderAmount:30^_^payerId:13910038665^_^payerIdType:0^_^payeeId:1743708677^_^payeeIdType:4^_^payerPayTypeId:1^_^payerAmount:30^_^payeePayTypeId:1^_^payeeAmount:30^_^realPayTypeId:1^_^realValueMert:30^_^bizId:3100010^_^bizAction:^_^orderSubject:300^_^orderItem:iospay^_^orderBeginTime:^_^orderEndTime:^_^orderExpireTime:^_^sndaSp:0^_^sndaApp:791000136^_^sndaArea:20012^_^sndaGroup:0^_^reqTime:20170324194852^_^resTime:^_^resCode:0^_^ext1:W1010129020025170324194852000001^_^ext2:2^_^memo:S1010129020025170324194852000001,0^_^paymentNo:410000245219437^_^mock:\",\"source_host\":\"10.129.20.25\",\"client_ip\":\"10.129.36.15\",\"timestamp\":\"2017-03-24T19:49:41.058+08:00\",\"proxy_ip\":\"10.129.20.17\",\"duration\":23,\"request_id\":\"020025149035618103410000\",\"res_str\":\"resultCode:0^_^resultMsg:\",\"msg_id\":2,\"soc_name\":\"991000582_1201\",\"app_id\":\"991000582\"}";

            //String pt_deposit = "2017-03-07 17:45:47\t{\"messageType\":102,\"orderId\":\"99000000027747170307174546781974\",\"contextId\":\"99000000027747170307174546781972\",\"appCode\":17,\"settleTime\":\"2017-03-07 17:45:46\",\"endpointIp\":\"123.59.101.136\",\"ptId\":\"mymir0615.sdo\",\"sndaId\":\"1146914768\",\"appId\":106,\"areaId\":617,\"payTypeId\":13,\"amount\":2,\"balanceBefore\":501,\"itemInfo\":\"20175,106,617,1,1,2\",\"payDetail\":\"\",\"messageId\":\"BS348148887994703400001\",\"messageSourceIp\":\"10.129.34.8\",\"messageTimestamp\":\"2017-03-07 17:45:47.034\"}";

            //String pt_deposit_103 = "2017-03-07 17:43:56\t{\"messageType\":103,\"orderId\":\"99000000030046170307174352452638\",\"contextId\":\"99000000030046170307174253450504\",\"appCode\":8,\"settleTime\":\"2017-03-07 17:43:56\",\"endpointIp\":\"0.0.0.0\",\"ptIdSrc\":\"hn00098552621.pt\",\"sndaIdSrc\":\"1973609525\",\"appIdSrc\":991002359,\"areaIdSrc\":5,\"payTypeIdSrc\":3,\"amountSrc\":63,\"ptId\":\"hn00098552621.pt\",\"sndaId\":\"1973609525\",\"appId\":991002359,\"areaId\":5,\"payTypeId\":3,\"amount\":63,\"balanceBefore\":366426,\"ptIdDest\":\"fi00688226404.pt\",\"sndaIdDest\":\"3493160875\",\"appIdDest\":991002359,\"areaIdDest\":5,\"payTypeIdDest\":3,\"amountDest\":63,\"payDetail\":\"\",\"feeSrc\":2,\"feeDest\":0,\"itemInfo\":\"1,991002359,5,1,1,65\",\"balanceBeforeSrc\":366426,\"balanceBeforeDest\":5926,\"messageId\":\"BS3437148887983650800001\",\"messageSourceIp\":\"10.129.34.37\",\"messageTimestamp\":\"2017-03-07 17:43:56.508\"}";
            String pt_deposit_108 = "2017-03-07 17:38:26\t{\"messageType\": 108,\"orderId\": \"99000000030046170307173822440472\",\"contextId\": \"99000000030046170307173822440472\",\"appCode\": 1,\"settleTime\": \"2017-03-07 17:38:26\",\"endpointIp\": \"222.172.177.76\",\"ptId\": \"kf00688152995.pt\",\"sndaId\": \"3493087466\",\"appId\": 991002359,\"areaId\": 5,\"payTypeId\": 2,\"amount\": 1800,\"balanceBefore\": 127578,\"itemInfo\": \"0\",\"messageId\": \"BS3412148887950652700001\",\"messageSourceIp\": \"10.129.34.12\",\"messageTimestamp\": \"2017-03-07 17:38:26.527\"}";

            producer.send(new ProducerRecord<String, String>(topic, Integer.toString(messageNo), pt_deposit_108));

            System.out.println("Thread " + Thread.currentThread().getName() + " " + pt_deposit_108);
            messageNo++;

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
