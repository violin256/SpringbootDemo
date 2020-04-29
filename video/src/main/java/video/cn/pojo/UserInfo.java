package video.cn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate

@Entity(name="users")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uno;
    private String uname;
    private String upwd;
    private String label;
    private String problems;
    private String answer;
    private String emails;
    @Column(columnDefinition = "varchar(255) default 'images/user.PNG'",nullable = false)
    private String uhead;
}
