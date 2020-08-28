#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

import lombok.Data;

/**
 *  自定义业务异常类
 *
 * @author chengchen
 * @version 1.0
 * @date 2020/4/29 15:43
 */
@Data
public class AppBizException extends RuntimeException {

    private String code;

    public AppBizException(String code, String message) {
        super(message);
        this.code = code;
    }

}
