package video.cn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="ttypes")
public class TtypesInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tno;
    private String typename;
    private int vno;
}
