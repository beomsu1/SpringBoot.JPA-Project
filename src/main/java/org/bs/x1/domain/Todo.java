package org.bs.x1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name= "tbl_todo2")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long tno;

    @Column(length = 300 , nullable = false)
    private String title;

    // 받아온 title을 컬럼 title에 대입
    public void changeTitle(String title){
        this.title=title;
    }

    
}
