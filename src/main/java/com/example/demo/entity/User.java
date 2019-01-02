package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // ID
    private Long id;
    // 姓名
    private String userName;
}

