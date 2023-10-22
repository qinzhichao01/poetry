package string_array

func canPermutePalindrome(s string) bool {
	var byteCount [128]int
	for _, ch := range s {
		byteCount[ch]++
	}
	var count = 0
	for _, pre := range byteCount {
		if pre%2 == 1 {
			count++
		}
	}
	return count <= 1
}
