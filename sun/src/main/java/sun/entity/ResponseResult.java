package sun.entity;

/**
 * 全局返回类
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class ResponseResult {
    // 状态码
    private Integer state = 200;
    // 状态消息
    private String  msg   = "success";
    // 数据类型
    private Object  data;

    public ResponseResult() {
    }

    public ResponseResult(Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public ResponseResult(Integer state, Exception e) {
        super();
        this.state = state;
        this.msg = e.getMessage();
    }

    public ResponseResult(Integer state, String msg, Object data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
}
