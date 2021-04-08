package com.heinsohntest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.heinsohntest.dto.InputDto;
import com.heinsohntest.dto.RequestDto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Service
@Slf4j
public class ServicePermutaciones {
	
	private List<InputDto> arrayPermutado = new ArrayList<>();
	private InputDto  valor;
	
	public  List<InputDto> init(RequestDto request){
		log.info("Obtención parametros Request ... ");
		log.info("Longitud ArrayList: "+request.getInput().size());
		log.info("Permutaciones: "+request.getPermutaciones());
		
		return getPermutacion (request.getInput(),request.getPermutaciones(), 0);
	}
	
	public List<InputDto> getPermutacion (List<InputDto> input, int permutaciones, int pos) {

		valor = new InputDto ();
		
		// Caso base
		if(permutaciones == 0) {
			return input;
		}
		//Reincio para n permutaciones
		if (pos == input.size()) {
			input = this.arrayPermutado;
			this.arrayPermutado  = new ArrayList<>();
			permutaciones = permutaciones -1;
			return getPermutacion(input, permutaciones, 0);
			
		}else {
			//Primer pocision
			if (pos == 0 ) {
				if (input.get(pos+1).getValor() == 0)
					valor.setValor(0);
				else
					valor.setValor(1);
				this.arrayPermutado.add(valor);
			}
			//Ultima pocision
			if (pos == input.size()-1 ) {
				if (input.get(pos-1).getValor() == 0) 
					valor.setValor(0);
				else
					valor.setValor(1);
				this.arrayPermutado.add(valor);
			}
			// Pocisiones diferentes a la primer y ultima
			if (pos != 0 && pos != input.size()-1) {
				if ( (input.get(pos-1).getValor() == 0 && input.get(pos+1).getValor() == 0) 
						|| (input.get(pos-1).getValor() == 1 && input.get(pos+1).getValor() == 1)  ) 
					valor.setValor(0);
				else
					valor.setValor(1);
				this.arrayPermutado.add(valor);
			}
			pos = pos +1;
			return getPermutacion(input, permutaciones, pos);
			
		}
			
	}
	

}
