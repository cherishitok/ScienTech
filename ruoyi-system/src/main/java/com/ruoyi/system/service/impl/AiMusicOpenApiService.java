package com.ruoyi.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.EmpSubscribe;
import org.apache.http.*;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 爱音乐平台开放API接口
 *
 * @author Jason
 */
@Service
public class AiMusicOpenApiService {

    private EmpSubscribeServiceImpl empSubscribeServiceImpl = new EmpSubscribeServiceImpl();

    private String generateMacSignature(String secret, String data) throws Exception {
        byte[] byteHMAC;
        String HMAC_SHA1 = "HmacSHA1";
        Mac mac = Mac.getInstance(HMAC_SHA1);
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(), HMAC_SHA1);
        mac.init(secretKey);
        byteHMAC = mac.doFinal(data.getBytes());
        return new BASE64Encoder().encode(byteHMAC);
    }

    private Map<String, String> getHeader(List<NameValuePair> nvps,String describe) throws Exception {
        Map<String, String> headers = new HashMap<>();
        String DEVICEID = "1000010409820";
        headers.put("auth-deviceid", DEVICEID);
        String CHANNELID = "5125";
        headers.put("auth-channelid", CHANNELID);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        String timestamp = format.format(new Date());
        headers.put("auth-timestamp", timestamp);
        headers.put("auth-signature-method", "HmacSHA1");
        StringBuilder sb = new StringBuilder();
        sb.append(DEVICEID).append("&");
        sb.append(CHANNELID).append("&");
        sb.append(timestamp).append("&");
        if (nvps != null && nvps.size() > 0)
            for (NameValuePair n : nvps)
                if ( n.getValue() != null )
                    sb.append(n.getValue()).append("&");
                else
                    sb.append("&");

        String DEVICE_SECRET = "Nor9QSG8Kj4M";
        String result = sb.toString();
        if("deletLast".equals(describe))
            result = sb.deleteCharAt(sb.length() - 1).toString();

        String auth_signature = generateMacSignature(DEVICE_SECRET, result);

        headers.put("auth-signature", auth_signature);
        return headers;
    }

    /**
     * 产品订购关系查询
     *
     * @param phone 手机号码
     * @return JSONObject
     * @throws Exception Exception
     */
    public JSONObject queryPackageList(String phone,String packageId,String isCountDownNum) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        String uri = "http://api.118100.cn/openapi/services/v2/package/packageservice/querypackagelist.json";
        HttpGet httpGet = new HttpGet();

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("mdn", phone));
        params.add(new BasicNameValuePair("package_id", packageId));
        params.add(new BasicNameValuePair("is_count_down_num", isCountDownNum));

        Map<String, String> headers = getHeader(params,"deletLast");
        for (Map.Entry m : headers.entrySet())
            httpGet.setHeader(m.getKey().toString(), m.getValue().toString());

        String entityStr = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
        httpGet.setURI(new URI(uri + "?" + entityStr));

        CloseableHttpResponse response = client.execute(httpGet);

        HttpEntity httpEntity = response.getEntity();
        return JSONObject.parseObject(EntityUtils.toString(httpEntity, Consts.UTF_8));
    }

    /**
     * EMP计费发起
     *
     * @param phone     手机号
     * @param packageId 产品编号
     * @return JSONObject
     * @throws Exception Exception
     */
    public JSONObject emplanunched(String phone, String packageId) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        String uri = "http://api.118100.cn/openapi/services/v2/package/packageservice/emplanunched.json";
        HttpPost httpPost = new HttpPost(uri);
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("mdn", phone));
        params.add(new BasicNameValuePair("package_id", packageId));



        Map<String, String> headers = getHeader(params,"lanunched");
        for (Map.Entry m : headers.entrySet())
            httpPost.setHeader(m.getKey().toString(), m.getValue().toString());

        httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        CloseableHttpResponse response = client.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();

        return JSONObject.parseObject(EntityUtils.toString(httpEntity, Consts.UTF_8));
    }

    /**
     * 根据验证码完成订购(先发起Emp计费)
     *
     * @param phone     手机号
     * @param packageId 产品代码
     * @param code      验证码
     * @return JSONObject
     * @throws Exception Exception
     */
    public JSONObject subscribeByEmp(String phone, String packageId, String code) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        String uri = "http://api.118100.cn/openapi/services/v2/package/packageservice/subscribebyemp.json";
        HttpPost httpPost = new HttpPost(uri);
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("mdn", phone));
        params.add(new BasicNameValuePair("package_id", packageId));
        params.add(new BasicNameValuePair("random_key", code));

        Map<String, String> headers = getHeader(params,"subscribe");
        for (Map.Entry m : headers.entrySet())
            httpPost.setHeader(m.getKey().toString(), m.getValue().toString());

        httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        CloseableHttpResponse response = client.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();

        return JSONObject.parseObject(EntityUtils.toString(httpEntity, Consts.UTF_8));
    }

    /**
     * 退订产品
     *
     * @param phone     手机号
     * @param packageId 产品编码
     * @return JSONObject
     * @throws Exception Exception
     */
    public JSONObject unsubscribeByEmp(String phone, String packageId) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        String uri = "http://api.118100.cn/openapi/services/v2/package/packageservice/unsubscribebyemp.json";

        HttpPost httpPost = new HttpPost(uri);
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("mdn", phone));
        params.add(new BasicNameValuePair("package_id", packageId));

        Map<String, String> headers = getHeader(params,"deletLast");
        for (Map.Entry m : headers.entrySet())
            httpPost.setHeader(m.getKey().toString(), m.getValue().toString());

        httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        CloseableHttpResponse response = client.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();

        return JSONObject.parseObject(EntityUtils.toString(httpEntity, Consts.UTF_8));
    }
}
