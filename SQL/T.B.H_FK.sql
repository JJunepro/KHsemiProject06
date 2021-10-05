
ALTER TABLE `Profile` ADD CONSTRAINT `FK_Member_TO_Profile_1` FOREIGN KEY (
	`M_ID`
)
REFERENCES `Member` (
	`M_ID`
);

ALTER TABLE `Profile` ADD CONSTRAINT `FK_Review_TO_Profile_1` FOREIGN KEY (
	`R_N`
)
REFERENCES `Review` (
	`R_N`
);

ALTER TABLE `Board_Recruit` ADD CONSTRAINT `FK_Member_TO_Board_Recruit_1` FOREIGN KEY (
	`M_ID`
)
REFERENCES `Member` (
	`M_ID`
);

ALTER TABLE `Board_Recruit` ADD CONSTRAINT `FK_Category_TO_Board_Recruit_1` FOREIGN KEY (
	`CA_N`
)
REFERENCES `Category` (
	`CA_N`
);

ALTER TABLE `Market_Comment` ADD CONSTRAINT `FK_Board_Market_TO_Market_Comment_1` FOREIGN KEY (
	`BM_N`
)
REFERENCES `Board_Market` (
	`BM_N`
);

ALTER TABLE `Market_Comment` ADD CONSTRAINT `FK_Board_Market_TO_Market_Comment_2` FOREIGN KEY (
	`M_ID`
)
REFERENCES `Board_Market` (
	`M_ID`
);

ALTER TABLE `Chat` ADD CONSTRAINT `FK_Board_Recruit_TO_Chat_1` FOREIGN KEY (
	`B_N`
)
REFERENCES `Board_Recruit` (
	`B_N`
);

ALTER TABLE `Chat` ADD CONSTRAINT `FK_Board_Recruit_TO_Chat_2` FOREIGN KEY (
	`M_ID`
)
REFERENCES `Board_Recruit` (
	`M_ID`
);

ALTER TABLE `TIME` ADD CONSTRAINT `FK_Board_Recruit_TO_TIME_1` FOREIGN KEY (
	`B_N`
)
REFERENCES `Board_Recruit` (
	`B_N`
);

ALTER TABLE `Application` ADD CONSTRAINT `FK_Board_Recruit_TO_Application_1` FOREIGN KEY (
	`M_ID`
)
REFERENCES `Board_Recruit` (
	`M_ID`
);

ALTER TABLE `Application` ADD CONSTRAINT `FK_Board_Recruit_TO_Application_2` FOREIGN KEY (
	`B_N`
)
REFERENCES `Board_Recruit` (
	`B_N`
);

ALTER TABLE `Review` ADD CONSTRAINT `FK_Board_Recruit_TO_Review_1` FOREIGN KEY (
	`B_N`
)
REFERENCES `Board_Recruit` (
	`B_N`
);

ALTER TABLE `Review` ADD CONSTRAINT `FK_Board_Recruit_TO_Review_2` FOREIGN KEY (
	`M_ID`
)
REFERENCES `Board_Recruit` (
	`M_ID`
);

ALTER TABLE `Board_Market` ADD CONSTRAINT `FK_Member_TO_Board_Market_1` FOREIGN KEY (
	`M_ID`
)
REFERENCES `Member` (
	`M_ID`
);

ALTER TABLE `Board_Market` ADD CONSTRAINT `FK_Category_TO_Board_Market_1` FOREIGN KEY (
	`CA_N`
)
REFERENCES `Category` (
	`CA_N`
);

ALTER TABLE `Board_Market` ADD CONSTRAINT `FK_Image_TO_Board_Market_1` FOREIGN KEY (
	`Image_N`
)
REFERENCES `Image` (
	`Image_N`
);

ALTER TABLE `Board_Notice` ADD CONSTRAINT `FK_Member_TO_Board_Notice_1` FOREIGN KEY (
	`M_ID`
)
REFERENCES `Member` (
	`M_ID`
);

ALTER TABLE `Wish` ADD CONSTRAINT `FK_Board_Recruit_TO_Wish_1` FOREIGN KEY (
	`B_N`
)
REFERENCES `Board_Recruit` (
	`B_N`
);

ALTER TABLE `Wish` ADD CONSTRAINT `FK_Board_Recruit_TO_Wish_2` FOREIGN KEY (
	`M_ID`
)
REFERENCES `Board_Recruit` (
	`M_ID`
);

ALTER TABLE `Board_Question` ADD CONSTRAINT `FK_Member_TO_Board_Question_1` FOREIGN KEY (
	`M_ID`
)
REFERENCES `Member` (
	`M_ID`
);

ALTER TABLE `Report` ADD CONSTRAINT `FK_Member_TO_Report_1` FOREIGN KEY (
	`M_ID`
)
REFERENCES `Member` (
	`M_ID`
);

