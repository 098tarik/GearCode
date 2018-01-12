package org.usfirst.frc.team86.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Relay;

public class GearB {

	private Solenoid extSol;
	private Solenoid rotSol;
	private Solenoid gripSol;

	
	public GearB(Solenoid extSol, Solenoid rotSol, Solenoid gripSol) {
		
		this.extSol = extSol;
		this.rotSol = rotSol;
		this.gripSol = gripSol;
	}
	
	public void gearGrab() {
		int state = 0;
		double time = 0;
		time = System.currentTimeMillis();
		switch(state){

         
		// rotate only if not extended 
		case 0:
			if(IO.grabButton.equals(true) && IO.solSen.equals(false)) {
		setGearState(false,false,true);
		} else if(IO.grabButton.equals(false)) {
			state = 5;
		}else {
			setGearState(false,false,false);
		}
		state++;
		break;
		
			
		// extend if gear is found
		case 1:
			if(IO.grabButton.equals(true) && IO.bannerSen.equals(true)) {
				time = System.currentTimeMillis();
				if(System.currentTimeMillis() > time + 500) {
					setGearState(true,false,true);
					state++;
				}
			}
		break;
		// grip after extended 
		case 2:
			time = System.currentTimeMillis();
			if(IO.solSen.equals(true) && System.currentTimeMillis() > time + 500) {
			setGearState(true,true,true);
			state++;
			}
			break;
			// retract after grip
		case 3: 
			time = System.currentTimeMillis();
			if(System.currentTimeMillis() > time + 500) {
			setGearState(false,true,true);
			state++; }
			break;
			// rotate after retract 
		case 4:
			time = System.currentTimeMillis();
			if(IO.solSen.equals(false) && System.currentTimeMillis() > time + 500) {
			setGearState(false,true,false);
			state++;
			}
			break;
			// release gear 
		case 5: 
			time = System.currentTimeMillis();
			if(IO.releaseButton.equals(true) && System.currentTimeMillis() > time + 500) {
				setGearState(false,false,false);
				state = 0;
			}
			break;
			
			default:
				
				setGearState(false,false,false);
				state = 0;
		}
	}
	
	
	
	public void setGearState(boolean ext, boolean grip, boolean rot ) {
		
		if(ext == true) 
			extSol.set(true);
		else if (ext == false)
			extSol.set(false);
			
		if(grip == true) 
			gripSol.set(true);
		else if (rot == false)
			gripSol.set(false);
		
		if(rot == true) 
			rotSol.set(true);
		else if (rot == false)
			rotSol.set(false);
			
	}
	
	public void updateCompressor(){
		if(IO.compressor.enabled())
			IO.compressorRelay.set(Relay.Value.kForward);
		else
			IO.compressorRelay.set(Relay.Value.kOff);
	}
}

