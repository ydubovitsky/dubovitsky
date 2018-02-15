package ru.job4j.max;

class MaxTest {
	@Test
	public void whenFirstLessSecond() {
    Max maxim = new Max();
    int result = maxim.max(1, 2);
    assertThat(result, is(2));
	}
	
	@Test
	public void whenFirstMoreSecond() {
    Max maxim = new Max();
    int result = maxim.max(1, -2);
    assertThat(result, is(1));
	}
}