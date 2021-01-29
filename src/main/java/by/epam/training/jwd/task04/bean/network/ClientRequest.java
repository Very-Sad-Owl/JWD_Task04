package by.epam.training.jwd.task04.bean.network;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class ClientRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private int taskCode;
    private Map<String, Object> params;

    public ClientRequest(){
    }

    public ClientRequest(int taskCode) {
        this.taskCode = taskCode;
    }

    public ClientRequest(int taskCode, Map<String, Object> params) {
        this.taskCode = taskCode;
        this.params = params;
    }

    public int getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(int taskCode) {
        this.taskCode = taskCode;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientRequest)) return false;
        ClientRequest that = (ClientRequest) o;
        return getTaskCode() == that.getTaskCode() &&
                Objects.equals(getParams(), that.getParams());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaskCode(), getParams());
    }

    @Override
    public String toString() {
        return "RequestBuilderImpl{" +
                "taskCode=" + taskCode +
                ", params=" + params +
                '}';
    }
}
