package com.cg.repository;

import com.cg.model.Transfer;
import com.cg.model.dto.TransferInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ITransferRepository extends JpaRepository<Transfer, Long> {
    @Transactional
    @Query(value = "SELECT * FROM vw_transfer_info", nativeQuery = true)
//    @Procedure("sp_get_transfer_info")
    List<TransferInfoDTO> getTransferInfo();
}
