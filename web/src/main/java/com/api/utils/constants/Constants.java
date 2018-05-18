package com.api.utils.constants;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName: Constants
 * @Description: 常量类
 * @author: Jivoin
 * @date: 2014年3月20日 上午10:21:49
 */
public class Constants {

	/**
	 * @fieldName: PAGECOUNT
	 * @fieldType: Integer
	 * @Description: 分页-每页条数
	 */
	public static final Integer PAGECOUNT = 5;
	
	/**
	 * @fieldName: LOGIN_MEMBER
	 * @fieldType: String
	 * @Description: session中登录会员常量
	 */
	public static final String LOGIN_MEMBER = "loginMember";
	
	/**
	 * @fieldName: RANDOM_PASSWORD_LENGTH
	 * @fieldType: int
	 * @Description: 随机短息密码长度
	 */
	public static final int RANDOM_PASSWORD_LENGTH = 6;
	
	/**
	 * @fieldName: VISIT_TYPE
	 * @fieldType: String
	 * @Description: 访问方式常量
	 */
	public static final String VISIT_TYPE = "visit_type";
	
	/**
	 * @fieldName: VISIT_TYPE_WEIXIN
	 * @fieldType: String
	 * @Description: 访问方式常量: 微信
	 */
	public static final String VISIT_TYPE_WEIXIN = "weixin";
	
	/**
	 * @fieldName: SYSTEM_PROPERTIES_NAME
	 * @fieldType: String
	 * @Description: 系统属性文件名
	 */
	public static final String SYSTEM_PROPERTIES_NAME = "system";
	
	/**
	 * @fieldName: MESSAGE_PROPERTIES_NAME_STRING
	 * @fieldType: String
	 * @Description: 短信属性文件
	 */
	public static final String MESSAGE_PROPERTIES_NAME_STRING ="message";
	
	/**
	 * @fieldName: SID
	 * @fieldType: String
	 * @Description: cookie中登录信息保存关键字
	 */
	public static final String SID = "token";
	
	
	/**
	 * @fieldName: IMG_SERVER_PATH
	 * @fieldType: String
	 * @Description: 图片压缩地址
	 */
	public static final String IMG_SERVER_PATH = "http://218.25.169.169";
	
	/**
	 * @fieldName: STORE_IDS
	 * @fieldType: String
	 * @Description: 店铺id数组session关键字
	 */
	public static final String STORE_IDS = "storeIds";
	
	/**
	 * @fieldName: DEFAULT_CITY_ID_KEY
	 * @fieldType: String
	 * @Description: 城市IDsession关键字
	 */
	public static final String DEFAULT_CITY_ID_KEY = "mypro_cityId";
	
	/**
	 * @fieldName: CITY_NAME_KEY
	 * @fieldType: String
	 * @Description: 城市名称session关键字
	 */
	public static final String CITY_NAME_KEY = "cityName";
	
	/**
	 * @fieldName: OPENID
	 * @fieldType: String
	 * @Description: 微信openid session关键字
	 */
	public static final String OPENID = "openid";
	
	/**
	 * @fieldName: SHOPID
	 * @fieldType: String
	 * @Description: 来源店铺ID参数关键字
	 */
	public static final String SHOPID = "shopid";
	
	/* Json 结果  key*/
	//执行结果 
	public static final String RESULT_JSON_KEY="result";
	//操作状态码
	public static final String CODE_JSON_KEY="code";
	//数据结果
	public static final String DATA_JSON_KEY="data";
	// 提示信息
	public static final String MESSAGE_JSON_KEY="message";
	//成功
	public static final String SUCCESS_JSON_KEY="success";
	//失败
	public static final String FAIL_JSON_KEY="fail";
	
	public static final String NO_BALANCE_KEY = "2010";
	
	/**
	 * @fieldName: NO_LOGIN_MEMBER_CODE
	 * @fieldType: String
	 * @Description: 用户未登陆错误码
	 */
	public static final String NO_LOGIN_MEMBER_CODE = "400";
	
	/**
	 * @fieldName: NO_LOGIN_MEMBER_MESSAGE
	 * @fieldType: String
	 * @Description: 用户未登陆错误信息
	 */
	public static final String NO_LOGIN_MEMBER_MESSAGE = "用户未登录";
	
	/**
	 * @fieldName: TOKEN
	 * @fieldType: String
	 * @Description: 授权关键字常量: token
	 */
	public static final String TOKEN = "token";
	
	/**
	 * @fieldName: ORDER_EFFECTIVE_TIME
	 * @fieldType: int
	 * @Description: 订单有效期(天)
	 */
	public static final int ORDER_EFFECTIVE_TIME = 7;
	
	/**
	 * @fieldName: CITY_ISHOT_CITY
	 * @fieldType: int
	 * @Description: 热门城市
	 */
	public static final int CITY_ISHOT_CITY = 1;
	
	/**
	 * @fieldName: CITY_ALL_CITY
	 * @fieldType: int
	 * @Description: 全部城市
	 */
	public static final int CITY_ALL_CITY = 0;
	
	
	public static final String REDIS_KEY = "userId";
	
	/**
	 * @fieldName: lON_LAT_CACHE_TIME
	 * @fieldType: Long
	 * @Description: 经纬度缓存时间，从配置文件中加载
	 */
	public static Long LON_LAT_CACHE_TIME = null;
	
	/**
	 * @fieldName: LON_LAT_KEY
	 * @fieldType: String
	 * @Description:  经纬度缓存key
	 */
	public static String LON_LAT_CACHE_KEY = "_lon_lat";
	
	
	/**
	 * @fieldName: RANDOM_PASSWORD_CACHE_KEY
	 * @fieldType: String
	 * @Description: 随即验证码key
	 */
	public static final String RANDOM_PASSWORD_CACHE_KEY = "randomPWD";
	
	/**
	 * @fieldName: BIGDECIMAL_DIVIDE_LEN
	 * @fieldType: Integer
	 * @Description: bigdecimal保留位数
	 */
	public static final Integer BIGDECIMAL_DIVIDE_LEN = 25;
	
	/**
	 * @fieldName: LON_BIGDECIMAL
	 * @fieldType: BigDecimal
	 * @Description: 同一经线上1KM相差的纬度
	 */
	public static BigDecimal LAT_DISTANCE = new BigDecimal("0.0090090090090090090090090");
	
	/**
	 * @fieldName: GPS_DISTANCE
	 * @fieldType: int
	 * @Description: 根据GPS定位取得所在城市(十公里内有店铺)
	 */
	public static int GPS_DISTANCE = 10;
	
	/**
	 * @fieldName: ORDER_DISTANCE
	 * @fieldType: int
	 * @Description: 店铺排序距离(两公里内距离排序)
	 */
	public static int ORDER_DISTANCE = 2;
	
	
	/**
	 * @fieldName: MAX_COUPON_CODE_COUNT
	 * @fieldType: int
	 * @Description: 个人活动券最大领取数
	 */
	public static final int MAX_COUPON_CODE_COUNT = 10;
	
	
	/**
	 * @fieldName: PWD_SHA_KEY
	 * @fieldType: String
	 * @Description: SHA加密算法key
	 */
	public static final String PWD_SHA_KEY = "SHA";

	/**
	 * @fieldName: DASHANG_SN
	 * @fieldType: String
	 * @Description: 短信消息签名常量
	 */
	public static final String DASHANG_SN = "[大商网]";
	
	/**
	 * @fieldName: TIANGOU_SN
	 * @fieldType: String
	 * @Description: 短信消息签名常量 -tg
	 */
	public static final String TIANGOU_SN = "[天狗网]";
	
	
	public static final String ANDROID_APK_PATH_KEY ="android.apkPath";
	
	public static final String ANDROID_APK_NAME_KEY ="android.apkName";
	
	public static final String MESSAGE_PRE_STRING ="【天狗网】您好！验证码为";
	
	public static final String MESSAGE_END_STRING ="，切勿将验证码泄露于他人，谢谢!";
	
	public static final String MESSAGE_ENCODE_STRING="GBK";
	/**
	 * 
	 * @ClassName: Sex
	 * @Description: 性别枚举
	 * @author: zhangting
	 * @date: 2014年7月9日 下午6:07:19
	 */
	public enum Sex {
	    MAN("男", 1), WOMEN("女", 2);  
	    // 成员变量  
	    private String name;  
	    private int index;  
	    // 构造方法  
	    private Sex(String name, int index) {  
	        this.name = name;  
	        this.index = index;  
	    }
	    
	    /**
	     * 
	     * @Title: getName
	     * @Description: 取值方法
	     * @param index
	     * @return
	     * @return: String
	     */
	    public static String getName(int index) {  
	        for (Sex c : Sex.values()) {  
	            if (c.getIndex() == index) {  
	                return c.name;  
	            }  
	        }  
	        return null;  
	    }  
	    
	    
	    public static Map<Integer, String>getMap(){
		    Map<Integer, String> sMap =new HashMap<Integer, String>();
		    for (Sex c : Sex.values()) {
				sMap.put(c.getIndex(), c.getName());
			}
		    	return sMap;
	    }
	    
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
	}
	
	public static void main(String [] args){
		System.out.println(Sex.MAN.name);
		System.out.println(Sex.MAN.index);
	}
}
