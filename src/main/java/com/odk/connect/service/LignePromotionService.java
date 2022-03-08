package com.odk.connect.service;

import java.util.List;

import com.odk.connect.exception.model.PromotionException;
import com.odk.connect.model.LignePromotion;

public interface LignePromotionService {
	LignePromotion save(LignePromotion lignePromo) throws PromotionException;
	LignePromotion update(Long idLignePromo, Long idPromo, Long idUser) throws PromotionException;
	LignePromotion findByLignePromoById(Long idLignePromo);
	List<LignePromotion> findAllLignePromo();
	List<LignePromotion>findHistoriquePromotion(Long id) throws PromotionException;
	 List<LignePromotion>findAllLignesPromotionByPromotionId(Long id) throws PromotionException;
	void deleteLignePromo(Long id);

}
