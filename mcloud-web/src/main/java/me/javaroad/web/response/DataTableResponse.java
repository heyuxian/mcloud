package me.javaroad.web.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataTableResponse<T> {
    private Long draw;
    private Long recordsTotal;
    private Long recordsFiltered;
    private List<T> data;

    public DataTableResponse(List<T> data, long totalElements, Long draw) {
        this.data = data;
        this.recordsTotal = totalElements;
        this.recordsFiltered = totalElements;
        this.draw = draw;
    }
}
