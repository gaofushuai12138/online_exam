package com.heeexy.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @description IP操作工具类
 * @author haixia.shi
 * @date 2018年1月10日
 *
 */
public class IPUtils {

    private static Logger logger = LoggerFactory.getLogger(IPUtils.class);

    //分割符
    private final static String IP_SEPARATOR = ",";

    // IP的正则
    private static Pattern pattern = Pattern
            .compile("(1\\d{1,2}|2[0-4]\\d|25[0-5]|\\d{1,2})\\."
                    + "(1\\d{1,2}|2[0-4]\\d|25[0-5]|\\d{1,2})\\."
                    + "(1\\d{1,2}|2[0-4]\\d|25[0-5]|\\d{1,2})\\."
                    + "(1\\d{1,2}|2[0-4]\\d|25[0-5]|\\d{1,2})");

    /**
     * 获取本机IP地址
     *
     * @return
     */
    public static String getLocalIPAddress() {

        InetAddress inet = null;

        try {
            inet = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return inet.getHostAddress();
    }

    /**
     * 获取IP地址
     *
     * 使用Nginx等反向代理软件， 则不能通过request.getRemoteAddr()获取IP地址
     * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，X-Forwarded-For中第一个非unknown的有效IP字符串，则为真实IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * 获取客户端Ip
     *
     * @param request
     * @return
     */
    public static String getIP(HttpServletRequest request) {

        String ip = request.getHeader("X-Real-IP");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        } else {
            return ip;
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        } else {
            // 当有多级反向代理时，x-forwarded-for值为多个时取第一个ip地址
            if (ip.indexOf(IP_SEPARATOR) != -1) {
                ip = ip.substring(0, ip.indexOf(IP_SEPARATOR));
            }
            return ip;
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        } else {
            return ip;
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        } else {
            return ip;
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = "";
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * 判断客户端的IP是否在某个ip段中
     *
     * @param clientIp
     *            客户端的IP
     * @param begin
     *            开始IP
     * @param end
     *            结束IP
     * @return
     */
    public static boolean isInner(long clientIp, long begin, long end) {
        return (clientIp >= begin) && (clientIp <= end);
    }

    /**
     * 分割IP
     *
     * @param ipAddress
     * @return
     */
    public static long getIpNum(String ipAddress) {
        String[] ip = ipAddress.split("\\.");
        long a = Integer.parseInt(ip[0]);
        long b = Integer.parseInt(ip[1]);
        long c = Integer.parseInt(ip[2]);
        long d = Integer.parseInt(ip[3]);
        long ipNum = a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
        return ipNum;
    }

    /**
     * 验证请求IP是否有效
     * @param requestIp
     * @param channelIp
     * @return
     */
    public static boolean valiRequestIp(String requestIp, String channelIp) {
        boolean flag = true;
        if ("all".equals(channelIp)) {
            flag = true;
        }
        String[] channelIps = channelIp.split("\\|");
        for (int r = 0; r < channelIps.length; r++) {
            if (channelIps[r].indexOf("-") != -1) {
                String[] unit = channelIps[r].split("-");
                if (unit.length == 2) {
                    long ip = getIpNum(requestIp);
                    long startIp = getIpNum(unit[0]);
                    long endIp = getIpNum(unit[1]);
                    if (isInner(ip, startIp, endIp)) {
                        flag = false;
                    }
                }
            } else {
                if (requestIp.equals(channelIps[r])) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    /**
     * 检查IP是否合法1
     *
     * @param ip
     * @return
     */
    public static boolean ipValid(String ip) {
        String regex0 = "(2[0-4]\\d)" + "|(25[0-5])";
        String regex1 = "1\\d{2}";
        String regex2 = "[1-9]\\d";
        String regex3 = "\\d";
        String regex = "(" + regex0 + ")|(" + regex1 + ")|(" + regex2 + ")|(" + regex3 + ")";
        regex = "(" + regex + ").(" + regex + ").(" + regex + ").(" + regex + ")";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ip);
        return m.matches();
    }

    /**
     * 检查IP是否合法2
     * @param ip
     * @return
     */
    public static boolean isValid(String ip)
    {
        Matcher m = pattern.matcher(ip);
        return m.matches();

    }
    /**
     * 通过IP获取归属地
     *
     * @param ip
     * @return
     */
    public static String getIpInfo(String ip) {
        if (ip.equals("本地")) {
            ip = "127.0.0.1";
        }
        String info = "";
        try {
            URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);
            HttpURLConnection htpcon = (HttpURLConnection) url.openConnection();
            htpcon.setRequestMethod("GET");
            htpcon.setDoOutput(true);
            htpcon.setDoInput(true);
            htpcon.setUseCaches(false);

            InputStream in = htpcon.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            StringBuffer temp = new StringBuffer();
            String line = bufferedReader.readLine();
            while (line != null) {
                temp.append(line).append("\r\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            JSONObject obj = (JSONObject) JSON.parse(temp.toString());
            if (obj.getIntValue("code") == 0) {
                JSONObject data = obj.getJSONObject("data");
                info += data.getString("country") + "-";
                info += data.getString("area") + "-";
                info += data.getString("region") + "-";
                info += data.getString("city") + "-";
                info += data.getString("isp");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }
}
