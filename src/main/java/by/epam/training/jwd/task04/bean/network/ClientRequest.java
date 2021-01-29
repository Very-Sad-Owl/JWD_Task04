package by.epam.training.jwd.task04.bean.network;

import by.epam.training.jwd.task04.bean.params_config.ParamName;
import by.epam.training.jwd.task04.bean.params_config.TaskNum;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class ClientRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private TaskNum taskCode;
    private Map<ParamName, Object> params;

    public ClientRequest(){
    }

    public ClientRequest(TaskNum taskCode) {
        this.taskCode = taskCode;
    }

    public ClientRequest(TaskNum taskCode, Map<ParamName, Object> params) {
        this.taskCode = taskCode;
        this.params = params;
    }

    public TaskNum getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(TaskNum taskCode) {
        this.taskCode = taskCode;
    }

    public Map<ParamName, Object> getParams() {
        return params;
    }

    public void setParams(Map<ParamName, Object> params) {
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
