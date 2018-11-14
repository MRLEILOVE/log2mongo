package xyz.yuanwl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Marker;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志实体类，可以给不同的数据源共用
 * @author Yuanwl
 * @date 2018-10-08 15:49:16
 * @version v1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log implements Serializable {

    private static final long serialVersionUID = -7288372263395673353L;

    @Id
    private String id;

    /** 日志等级 */
    private String level;
    /** 日志记录者，一般是记录本日志的目标全类名 */
    private String loggerName;
    /** 日志信息 */
    private String message;
    /** 日志来源 */
    private Map<String, Object> source;
    /** 日志标记 */
    private Marker marker;

    /** 记录日志时所在的线程ID */
    private Long threadId;
    /** 记录日志时所在的线程名 */
    private String threadName;
    /** 记录日志时所在的线程优先级 */
    private Integer threadPriority;

    /** 日志时间毫秒数 */
    private Long millis;
    /** 日志时间 */
    private Date date;

    /** 出现异常时抛出的异常信息 */
    private Thrown thrown;


    /**
     * 内部类：异常抛出信息
     * @author Yuanwl
     * @date 2018-11-14 09:29:53
     * @version v1.0.0
     */
    @Data
    private class Thrown {
        /** 异常类 */
        private String type;
        /** 异常信息 */
        private String message;
        /** 异常栈跟踪链 */
        private List<Map<String, String>> stackTrace;
    }
}