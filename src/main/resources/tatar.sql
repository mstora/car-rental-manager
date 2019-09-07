Database : `Clients`


CREATE TABLE IF NOT EXISTS `Clients` (

  `id` Long(10) unsigned NOT NULL auto_increment,
  `name` varchar(255) NOT NULL default '',
  `dateOfBirth` date ("YYYY-MM-DD),

  PRIMARY KEY  (`id`)
)

  DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
INSERT INTO Clients (id, name,dateOfBirth)
VALUES (1, 'Smith',  1-01-993)
-- --------------------------------------------------------