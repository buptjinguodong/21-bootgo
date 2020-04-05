DROP TABLE IF EXISTS `ay_user`;
CREATE TABLE `ay_user` (
  `id` varchar (32) NOT NULL COMMENT '主键',
  `name` varchar (10) DEFAULT NULL COMMENT '用户名',
  `password` varchar (32) DEFAULT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `ay_user` ('1', 'aaa', '123456')
INSERT INTO `ay_user` ('2', 'a拉', '123456')

DROP TABLE IF EXISTS `ay_mood`;
CREATE TABLE `ay_mood` (
  `id` int(32) not null,
  `content` varchar(256) DEFAULT NULL,
  `user_id` varchar (32) DEFAULT NULL,
  `praise_num` int(11) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  primary key (`id`),
  key `mode_user_id_index` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

