package com.hmago.learn.spring.springasynctvshow.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowResponse extends BaseResponse {
    private Show show;
    private List<Cast> casts;
    private List<Episode> episodes;

    @Builder(builderMethodName ="baseResponse")
    public ShowResponse(Show show, List<Cast> casts, List<Episode> episodes, boolean success, String code, String msg) {
        this.show = show;
        this.casts = casts;
        this.episodes = episodes;
        super.success =success;
        super.code=code;
        super.msg=msg;
    }
}

