package string_array

func isUnique(astr string) bool {
	if len(astr) <= 1 {
		return true
	}
	aMap := map[rune]bool{}
	for _, val := range astr {
		if aMap[val] {
			return false
		}
		aMap[val] = true
	}
	return false
}
