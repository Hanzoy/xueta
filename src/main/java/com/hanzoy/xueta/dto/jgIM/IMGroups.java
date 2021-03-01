package com.hanzoy.xueta.dto.jgIM;

import lombok.Data;

import java.util.List;

@Data
public class IMGroups {
    private List<IMGroup> list;

    @Data
    public static class IMGroup{
        private int gid;
        private String name;
        private String ctime;
        private String avatar;
        private String mtime;
        private String max_member_count;
        private String desc;
    }
}
