package org.usfirst.frc.team86.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;

public class GearB {

	private Solenoid extSol;
	private Solenoid rotSol;
	private Solenoid gripSol;
	private DigitalInput bannarSen;
	private DigitalInput solSen;
	
	public GearB(Solenoid extSol, Solenoid rotSol, Solenoid gripSol, DigitalInput bannerSen, DigitalInput solSen ) {
		
		this.extSol = extSol;
		this.rotSol = rotSol;
		this.gripSol = gripSol;
		this.bannarSen = bannerSen;
		this.solSen = solSen;
		
	}
	
	public void gearGrab() {
		int state = 0;
		double time = 0;
		switch(state) {

		case 0:
		time = System.currentTimeMillis();
		setGearState(false,false,true);
		state++;
		break;
		case 1:
			setGearState(true,false,true);
		break;
		case 2:
			setGearState(true,true,true);
			break;
			
		case 3:
			setGearState(false,true,true);
			break;
			
		case 4:
			setGearState(false,true,false);
			break;
			
			default:
				
				setGearState(false,false,false);
				
			
		}
	}
	
	
	
	public void setGearState(boolean ext, boolean grip, boolean rot ) {
		
		if(ext) 
			extSol.set(true);
		else 
			extSol.set(false);
			
		if(grip) 
			gripSol.set(true);
		else
			gripSol.set(false);
		
		if(rot) 
			rotSol.set(true);
		else
			rotSol.set(false);
			
			
		
	}
}

