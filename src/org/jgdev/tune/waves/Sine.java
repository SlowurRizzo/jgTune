package org.jgdev.tune.waves;

public class Sine implements Wave {

	@Override
	public byte[] getSamples(int n) {
		byte[] samples = new byte[n];
		
		for(int t=0; t<n; t++)
			samples[t] = getSample(1f, (float)(t)/n);
		
		return samples;
	}

	@Override
	public byte getSample(float freq, long millis) {
		return getSample(freq, millis/1000f);
	}

	@Override
	public byte getSample(float freq, float sec) {
		float x = sec % (1f + Float.MIN_NORMAL);
		float y = (float) Math.sin(x * Math.PI * 2 * freq);
		return (byte) (Math.round((y/2f + 0.5f) *255) - 128);
	}

}
