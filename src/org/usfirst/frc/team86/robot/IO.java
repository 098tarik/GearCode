package org.usfirst.frc.team86.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class IO {
	
	public static Solenoid extSol = new Solenoid(1, 0);
	public static Solenoid rotSol = new Solenoid(1, 1);
	public static Solenoid gripSol = new Solenoid(1, 2);
	
	public static Compressor compressor = new Compressor(1);
	public static Relay compressorRelay = new Relay(0);
	
	public static DigitalInput bannerSen = new DigitalInput(1);
	public static DigitalInput solSen = new DigitalInput(0);
	
	public static Button grabButton = new JoystickButton(coJoystick, 11);
	public static Button releaseButton = new JoystickButton(coJoystick, 12);

}
