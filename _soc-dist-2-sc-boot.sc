
(
SuperDirt.postBadValues = false;

s.options.device_("JackRouter");

s.options.numBuffers = 1024 * 16;
s.options.memSize = 8192 * 16;
s.options.maxNodes = 1024 * 64;
s.options.numOutputBusChannels = 8;
s.options.numInputBusChannels = 0;

s.waitForBoot {
	~dirt = SuperDirt(2, s);

	~dirt.loadSoundFiles("~/studio/tidal-samples/tracks/shared/*");
	~dirt.loadSoundFiles("~/studio/tidal-samples-2/lazyfish/*");

	s.sync;
	~dirt.start(57120, [0, 2, 4, 6]);


	// "Analog Four", "Elektron MIDI"


	MIDIClient.init;
	// ~midiOut = MIDIOut.newByName("Scarlett 18i8 USB", "Scarlett 18i8 USB");
	// ~midiOut.latency = 0;
	// ~dirt.soundLibrary.addMIDI(\midi, ~midiOut);

	~rytmOut = MIDIOut.newByName("Elektron Analog Rytm", "Analog Rytm out 1");
	~rytmOut.latency = 0;
	~dirt.soundLibrary.addMIDI(\rytm, ~rytmOut);

	~harmorOut = MIDIOut.newByName("IAC Driver", "Bus 1");
	~harmorOut.latency = 0;
	~dirt.soundLibrary.addMIDI(\harmor, ~harmorOut);


};
s.latency = 0;
);


