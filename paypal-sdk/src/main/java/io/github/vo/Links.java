package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Links {

    /**
     * 完整的目标 URL。
     * 要进行相关调用，请将该方法与此URI 模板格式的链接结合使用。对于预处理，包括$、(和)字符。这href是关键的 HATEOAS 组件，它将已完成的调用与后续调用联系起来。
     */
    @JsonProperty("href")
    private String href;

    /**
     * 链接关系类型，用作明确描述链接语义的链接的 ID 。请参阅链接关系。
     * https://www.iana.org/assignments/link-relations/link-relations.xhtml
     */
    @JsonProperty("rel")
    private String rel;

    /**
     * 进行相关调用所需的 HTTP 方法。
     */
    @JsonProperty("method")
    private String method;
}
