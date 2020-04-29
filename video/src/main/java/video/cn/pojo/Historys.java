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
@Entity(name="historys")
public class Historys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hno;
    private String fname;
    private String hdates;
    private String uname;
}
