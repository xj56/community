package com.discussion.community.model;

import lombok.Data;

/**
 * @author jie
 */
@Data
public class User {
    private String name;
    private String password;

    public User(String name) {
        this.name = name;
    }

    private User(Builder builder) {
        this.name = builder.name;
        this.password = builder.password;
    }


    public static class Builder {
        private final String name;
        private String password;

        public Builder(String name) {
            this.name = name;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
