package utils;/**
 * Create by hongcq on 2019/3/19
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 *@Description TODO
 *@author cp
 *@date 2019/3/19 12:10
 *@ClassName ResponseBean
 */
public class ResponseBean {
    //定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    //响应业务状态
    private Integer status;
    //响应信息
    private String msg;
    //响应中的数据
    private Object data;


    public ResponseBean() {

    }
    public ResponseBean(Object data2) {
        // TODO Auto-generated constructor stub
        this.status = 200;
        this.msg = "OK";
        this.data = data2;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public ResponseBean(Integer status2, String msg2, Object data2) {
        // TODO Auto-generated constructor stub
        this.status = status2;
        this.msg = msg2;
        this.data = data2;
    }

    public static ResponseBean build(Integer status, String msg, Object data) {
        return new ResponseBean(status, msg, data);
    }

    public static ResponseBean ok(Object data) {
        return new ResponseBean(data);
    }

    public static ResponseBean ok() {
        return new ResponseBean(null);
    }

    public static ResponseBean build(Integer status, String msg) {
        return new ResponseBean(status, msg, null);
    }

    /**
     * 将json结果集转化为TaotaoResult对象
     *
     * @param jsonData json数据
     * @param clazz TaotaoResult中的object类型
     * @return
     */
    public static ResponseBean formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, ResponseBean.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static ResponseBean format(String json) {
        try {
            return MAPPER.readValue(json, ResponseBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static ResponseBean formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
