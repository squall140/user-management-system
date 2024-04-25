-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user" (
                                     "user_id" bigserial,
                                     "dept_id" int8,
                                     "user_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
                                     "nick_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
                                     "user_type" varchar(2) COLLATE "pg_catalog"."default",
                                     "email" varchar(50) COLLATE "pg_catalog"."default",
                                     "phonenumber" varchar(11) COLLATE "pg_catalog"."default",
                                     "sex" char(1) COLLATE "pg_catalog"."default",
                                     "avatar" varchar(100) COLLATE "pg_catalog"."default",
                                     "password" varchar(100) COLLATE "pg_catalog"."default",
                                     "status" char(1) COLLATE "pg_catalog"."default",
                                     "del_flag" char(1) default '0',
                                     "login_ip" varchar(128) COLLATE "pg_catalog"."default",
                                     "login_date" timestamp(6),
                                     "create_by" varchar(64) COLLATE "pg_catalog"."default",
                                     "create_time" timestamp(6),
                                     "update_by" varchar(64) COLLATE "pg_catalog"."default",
                                     "update_time" timestamp(6),
                                     "remark" varchar(500) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_user"."user_id" IS '用户ID';
COMMENT ON COLUMN "public"."sys_user"."dept_id" IS '部门ID';
COMMENT ON COLUMN "public"."sys_user"."user_name" IS '用户账号';
COMMENT ON COLUMN "public"."sys_user"."nick_name" IS '用户昵称';
COMMENT ON COLUMN "public"."sys_user"."user_type" IS '用户类型（00系统用户）';
COMMENT ON COLUMN "public"."sys_user"."email" IS '用户邮箱';
COMMENT ON COLUMN "public"."sys_user"."phonenumber" IS '手机号码';
COMMENT ON COLUMN "public"."sys_user"."sex" IS '用户性别（0男 1女 2未知）';
COMMENT ON COLUMN "public"."sys_user"."avatar" IS '头像地址';
COMMENT ON COLUMN "public"."sys_user"."password" IS '密码';
COMMENT ON COLUMN "public"."sys_user"."status" IS '帐号状态（0正常 1停用）';
COMMENT ON COLUMN "public"."sys_user"."del_flag" IS '删除标志（0代表存在 2代表删除）';
COMMENT ON COLUMN "public"."sys_user"."login_ip" IS '最后登录IP';
COMMENT ON COLUMN "public"."sys_user"."login_date" IS '最后登录时间';
COMMENT ON COLUMN "public"."sys_user"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."sys_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_user"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."sys_user"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_user"."remark" IS '备注';
COMMENT ON TABLE "public"."sys_user" IS '用户信息表';
