package ongTest.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FranDto {
        private int franNo;         // 가맹점번호 PK
        private String franName;    // 가맹점명
        private String franAddress; // 상세주소
        private String franCall;    // 전화번호
        private String franOwner;   // 가맹주명
        private boolean franStatus; // 폐점여부
        private int P;              // 매출( orderQty * orderPrice )
} // class end
